package secure;

import entity.Reader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servlets.Library;
import session.ReaderFacade;
import session.RoleFacade;
import session.UserRolesFacade;
import util.EncriptPass;
import util.PageReturner;

/**
 * @author Sanata
 */
//loadOnStartup = 1, - назначение админа сразу при старте приложения
@WebServlet(loadOnStartup = 1, name = "Secure", urlPatterns = {
    "/login",
    "/logout",
    "/showLogin",
    "/addRole",
    "/editUserRoles",
    "/changeUserRole"

})
public class Secure extends HttpServlet {

    @EJB
    RoleFacade roleFacade;

    @EJB
    ReaderFacade readerFacade;

    @EJB
    UserRolesFacade userRolesFacade;

    @Override // когда БД пользователей еще пуста, создание первого пользователя, назначение ему роли админа, запись в БД
    public void init() throws ServletException {
        List<Reader> listReaders = readerFacade.findAll();
        if (listReaders.isEmpty()) {
            EncriptPass ep = new EncriptPass();
            String salts = ep.createSalts();
            String encriptPass = ep.setEncriptPass("123456", salts);
            
            Reader reader = new Reader("Sam", "Sambba", "55555555", "Tallinn", "sambba", encriptPass, salts);// dannoe
            readerFacade.create(reader);
            Role role = new Role();//sozdat pustuja rol
            role.setName("ADMIN"); //iniciacija adminom
            roleFacade.create(role);//sozdanie v DB
            UserRoles ur = new UserRoles();//
            ur.setReader(reader);
            ur.setRole(role);
            userRolesFacade.create(ur);
            role.setName("USER");
            roleFacade.create(role);//novaja zapis v DB s novot rolju
            ur.setReader(reader);
            ur.setRole(role);
            userRolesFacade.create(ur);//sozdanie novoi zapisi s nov.dannimi
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF8");
        HttpSession session = request.getSession(false);//esli sessii net< jna ne sozdaetsja
        Reader regUser = null;
        if (session != null) {
            try {
                regUser = (Reader) session.getAttribute("regUser");
            } catch (Exception e) {
                regUser = null;
            }
        }
        SecureLogic sl = new SecureLogic();
        String path = request.getServletPath();
        if (null != path) {
            switch (path) {
                case "/login":
                    String login = request.getParameter("login");
                    String password = request.getParameter("password");
                    request.setAttribute("info", "Нет такого пользователя!");
                    regUser = readerFacade.fineByLogin(login);
                    if (regUser == null) {
                        request.getRequestDispatcher(PageReturner.getPage("showLogin")).forward(request, response);
                        break;
                    }
                    EncriptPass ep = new EncriptPass();
                    String salts = regUser.getSalts();
                    String encriptPass = ep.setEncriptPass(password, salts);
                    if (encriptPass.equals(regUser.getPassword())) {
                        session = request.getSession(true);
                        session.setAttribute("regUser", regUser);
                        request.setAttribute("info", regUser.getName() + "! Вы увспешно вошли в систему!");
                        request.getRequestDispatcher(PageReturner.getPage("welcom")).forward(request, response);
                        break;
                    }
                    request.getRequestDispatcher(PageReturner.getPage("showLogin")).forward(request, response);
                    break;
                case "/showLogin":
                    request.getRequestDispatcher(PageReturner.getPage("showLogin")).forward(request, response);
                    break;
//                case "/newRole":// v sessii hranenie dannoh 20-30 minut, v zavisimosti ot servera
//                    if (!"ADMIN".equals(sl.getRole(regUser))) {
//                        request.getRequestDispatcher(PageReturner.getPage("showLogin")).forward(request, response);
//                        break;
//                    }
//                    request.getRequestDispatcher(PageReturner.getPage("newRole")).forward(request, response);
//                    break;
                case "/logout":
                    if (session != null) {
                        session.invalidate();
                        request.setAttribute("info", "Вы вышли из системы");
                    }
                    request.getRequestDispatcher(PageReturner.getPage("welcom"))
                                .forward(request, response);
                    break;
//                case "/addRole":
//                    if (!"ADMIN".equals(sl.getRole(regUser))) {
//                        request.getRequestDispatcher(PageReturner.getPage("showLogin")).forward(request, response);
//                        break;
//                    }
//                    String nameRole = request.getParameter("nameRole");//s4itati vvedenniju rol
//                    Role role = new Role();
//                    role.setName(nameRole.toUpperCase());//dobavlena rol bez constructora iz classa Role
//                    try {
//                        if (!role.getName().isEmpty()) {
//                            roleFacade.create(role);
//                        } else {
//                            request.setAttribute("info", "Empty! Поле пустое! Ввести роль для пользователя!");
//                        }
//                    } catch (Exception e) {
//                        request.setAttribute("info", "Такая роль уже существует!");
//                    }
//                    request.getRequestDispatcher(PageReturner.getPage("newRole")).forward(request, response);
//                    break;
                case "/editUserRoles":
                    if (!"ADMIN".equals(sl.getRole(regUser))) {
                        request.getRequestDispatcher(PageReturner.getPage("showLogin")).forward(request, response);
                        break;
                    }
                    Map<Reader, String> mapUsers = new HashMap<>();
                    List<Reader> listUsers = readerFacade.findAll();
                    int n = listUsers.size();
                    for (int i = 0; i < n; i++) {
                        mapUsers.put(listUsers.get(i), sl.getRole(listUsers.get(i)));
                    }
//                    List<Reader> listUsers = readerFacade.findAll();
//                    request.setAttribute("listUsers", listUsers);
                    request.setAttribute("mapUsers", mapUsers);
                    List<Role> listRoles = roleFacade.findAll();
                    request.setAttribute("listRoles", listRoles);
                    request.getRequestDispatcher(PageReturner.getPage("editUserRoles")).forward(request, response);
                    break;
                case "/changeUserRole":
                    if (!"ADMIN".equals(sl.getRole(regUser))) {
                        request.getRequestDispatcher(PageReturner.getPage("showLogin")).forward(request, response);
                        break;
                    }
                    String setButton = request.getParameter("setButton");
                    String deleteButton = request.getParameter("deleteButton");
                    String userId = request.getParameter("user");
                    String roleId = request.getParameter("role");
                    Reader reader = readerFacade.find(new Long(userId));
                    Role roleToUser = roleFacade.find(new Long(roleId));
                    UserRoles ur = new UserRoles(reader, roleToUser);

                    if (setButton != null) {
                        sl.addRoleToUser(ur);
                    }
                    if (deleteButton != null) {
                        sl.deleteRoleToUser(ur.getReader());
                    }
                    mapUsers = new HashMap<>();
                    listUsers = readerFacade.findAll();
                    n = listUsers.size();
                    for (int i = 0; i < n; i++) {
                        mapUsers.put(listUsers.get(i), sl.getRole(listUsers.get(i)));
                    }
                    request.setAttribute("mapUsers", mapUsers);
//                    List<Reader> newListUsers = readerFacade.findAll();
//                    request.setAttribute("listUsers", newListUsers);
                    List<Role> newListRoles = roleFacade.findAll();
                    request.setAttribute("listRoles", newListRoles);
                    request.getRequestDispatcher(PageReturner.getPage("editUserRoles")).forward(request, response);
                    break;
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
