/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 * Provides an Account Balance and Basic Withdrawal/Deposit Operations
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    
    Account accnt = new Account();
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if(request.getParameter("deposit")!= null)
        {
            double deposit1 = Double.parseDouble(request.getParameter("deposit"));
            accnt.deposit(deposit1);
        }
        else if(request.getParameter("withdraw")!= null)
        {
           
             double withdraw1 = Double.parseDouble(request.getParameter("withdraw"));
            accnt.withdraw(withdraw1);
        }
        else
        {
            accnt.close();
        }
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.getWriter().write(String.valueOf(accnt.getBalance()));
    }
    
}
