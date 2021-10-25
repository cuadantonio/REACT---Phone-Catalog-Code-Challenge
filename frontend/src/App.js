import './App.css';
import React, {Component} from 'react';
import "bootstrap/dist/css/bootstrap.rtl.css";
import {Switch,Route,Link} from "react-router-dom";

import Phone from "./components/phone.component";
import PhoneList from "./components/phone-list.component";

class App extends Component{
  render() {
    return(
        <div>
          <nav className="navbar navbar-expand navbar-dark navigateBar">
            <a href="/phones" className="navbar-brand">
              Phone Catalog
            </a>
            <div className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link to={"/phones"} className="nav-link">
                  Phones
                </Link>
              </li>
            </div>
          </nav>

          <div className="container mt-3">
            <Switch>
              <Route exact path={["/", "/phones/"]} component={PhoneList} />
              <Route path="/phones/:id" component={Phone} />
            </Switch>
          </div>
        </div>
    );
  }
}

export default App;
