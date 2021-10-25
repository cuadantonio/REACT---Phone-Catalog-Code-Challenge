import React, { Component } from "react";
import PhoneDataService from "../services/phone.service";
import {Link} from "react-router-dom";

export default class Phone extends Component{
    constructor(props) {
        super(props);
        this.onChangeName = this.onChangeName.bind(this);
        this.onChangeManufacturer = this.onChangeManufacturer.bind(this);
        this.onChangeDescription = this.onChangeDescription.bind(this);
        this.onChangeColor = this.onChangeColor.bind(this);
        this.onChangePrice = this.onChangePrice.bind(this);
        this.onChangeScreen = this.onChangeScreen.bind(this);
        this.onChangeProcessor = this.onChangeProcessor.bind(this);
        this.onChangeRam = this.onChangeRam.bind(this);
        this.onChangeImageFileName = this.onChangeImageFileName.bind(this);
        this.getPhone = this.getPhone.bind(this);
        this.deletePhone = this.deletePhone.bind(this);

        this.state = {
            currentPhone: {
                id: null,
                name: "",
                manufacturer: "",
                description:"",
                color:"",
                price:null,
                screen:"",
                processor:"",
                ram:null,
                imageFileName:""
            },
            message: ""
        };
    }

    componentDidMount() {
        this.getPhone(this.props.match.params.id);
    }

    onChangeName(e){
        const name = e.target.value;

        this.setState(function(prevState){
            return{
                currentPhone:{
                    ...prevState.currentPhone,
                    name: name
                }
            };
        });
    }

    onChangeManufacturer(e){
        const manufacturer = e.target.value;

        this.setState(function(prevState){
            return{
                currentPhone:{
                    ...prevState.currentPhone,
                    manufacturer: manufacturer
                }
            };
        });
    }

    onChangeDescription(e){
        const description = e.target.value;

        this.setState(function(prevState){
            return{
                currentPhone:{
                    ...prevState.currentPhone,
                    description: description
                }
            };
        });
    }

    onChangeColor(e){
        const color = e.target.value;

        this.setState(function(prevState){
            return{
                currentPhone:{
                    ...prevState.currentPhone,
                    color: color
                }
            };
        });
    }

    onChangePrice(e){
        const price = e.target.value;

        this.setState(function(prevState){
            return{
                currentPhone:{
                    ...prevState.currentPhone,
                    price: price
                }
            };
        });
    }

    onChangeScreen(e){
        const screen = e.target.value;

        this.setState(function(prevState){
            return{
                currentPhone:{
                    ...prevState.currentPhone,
                    screen: screen
                }
            };
        });
    }

    onChangeProcessor(e){
        const processor = e.target.value;

        this.setState(function(prevState){
            return{
                currentPhone:{
                    ...prevState.currentPhone,
                    processor: processor
                }
            };
        });
    }

    onChangeRam(e){
        const ram = e.target.value;

        this.setState(function(prevState){
            return{
                currentPhone:{
                    ...prevState.currentPhone,
                    ram: ram
                }
            };
        });
    }

    onChangeImageFileName(e){
        const imageFileName = e.target.value;

        this.setState(function(prevState){
            return{
                currentPhone:{
                    ...prevState.currentPhone,
                    imageFileName: imageFileName
                }
            };
        });
    }

    getPhone(id) {
        PhoneDataService.get(id)
            .then(response => {
                this.setState({
                    currentPhone: response.data
                });
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    deletePhone() {
        PhoneDataService.delete(this.state.currentPhone.id)
            .then(response => {
                console.log(response.data);
                this.props.history.push('/phones/')
            })
            .catch(e => {
                console.log(e);
            });
    }

    render(){
        const {currentPhone} = this.state;

        return(
            <div>
                <div className="edit-form">
                    <h1><span className="phoneTitle">{currentPhone.name}</span></h1>
                    <img src={currentPhone.imageFileName} alt={currentPhone.name} height="250" width="250"/>
                    <div className="form-group">
                        Manufacturer: <span className="phoneData">{currentPhone.manufacturer}</span>
                    </div>
                    <div className="form-group">
                        Description: <span className="phoneData">{currentPhone.description}</span>
                    </div>
                    <div className="form-group">
                        Color: <span className="phoneData">{currentPhone.color}</span>
                    </div>
                    <div className="form-group">
                        Price: <span className="phoneData">{currentPhone.price}</span>
                    </div>
                    <div className="form-group">
                        Screen: <span className="phoneData">{currentPhone.screen}</span>
                    </div>
                    <div className="form-group">
                        Processor: <span className="phoneData">{currentPhone.processor}</span>
                    </div>
                    <div className="form-group">
                        Ram: <span className="phoneData">{currentPhone.ram}</span>
                    </div>


                    <button
                        className="badge"
                        onClick={this.deletePhone}
                    >
                        Delete
                    </button>

                </div>
            </div>
        );
    }
}
