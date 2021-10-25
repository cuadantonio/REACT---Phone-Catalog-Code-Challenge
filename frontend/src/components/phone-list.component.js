import React, { Component } from "react";
import PhoneDataService from "../services/phone.service";
import { Link } from "react-router-dom";


export default class PhonesList extends Component{
    constructor(props) {
        super(props);
        this.retrievePhones = this.retrievePhones.bind(this);
        this.state = {
            phones: []
        };
    }

    componentDidMount() {
        this.retrievePhones();
    }


    retrievePhones() {
        PhoneDataService.getAll()
            .then(response => {
                this.setState({
                    phones: response.data
                });
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }



    render(){
        const {phones} = this.state;
        return(
            <div className="list row">

                <div className="col-md-6">
                    <h1>Phones List</h1>

                        {phones &&
                        phones.map((phone) => (
                        <div>
                            <Link to={"/phones/"+ phone.id} className="nav-link">
                                <h3 className="phoneTitle">{phone.name}</h3>
                                <br/>
                                <img src={phone.imageFileName} alt={phone.name} height="250" width="250"/>
                                <br/>
                            </Link>
                        </div>



                        ))}

                </div>
            </div>
        );
    }
}
