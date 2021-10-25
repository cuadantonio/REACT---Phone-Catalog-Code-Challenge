import React, {Component} from "react";
import PhoneDataService from "../services/phone.service";

export default class AddPhone extends Component{
    constructor(props) {
        super(props);
        this.onChangeName=this.onChangeName.bind(this);
        this.onChangeManufacturer=this.onChangeManufacturer.bind(this);
        this.onChangeDescription=this.onChangeDescription.bind(this);
        this.onChangeColor=this.onChangeColor.bind(this);
        this.onChangePrice=this.onChangePrice.bind(this);
        this.onChangeScreen=this.onChangeScreen.bind(this);
        this.onChangeProcessor=this.onChangeProcessor.bind(this);
        this.onChangeRam=this.onChangeRam.bind(this);
        this.onChangeImageFileName=this.onChangeImageFileName.bind(this);
        this.savePhone=this.savePhone.bind(this);
        this.newPhone=this.newPhone.bind(this);

        this.state={
            id:null,
            name:"",
            manufacturer:"",
            description:"",
            color:"",
            price:null,
            screen:"",
            processor:"",
            ram:null,
            imageFileName:"",
            submitted:false
        };
    }

    onChangeName(e){
        this.setState({
            name: e.target.value
        });
    }

    onChangeManufacturer(e){
        this.setState({
            manufacturer: e.target.value
        });
    }

    onChangeDescription(e){
        this.setState({
            description: e.target.value
        });
    }

    onChangeColor(e){
        this.setState({
            color: e.target.value
        });
    }

    onChangePrice(e){
        this.setState({
            price: e.target.value
        });
    }

    onChangeScreen(e){
        this.setState({
            screen: e.target.value
        });
    }

    onChangeProcessor(e){
        this.setState({
            processor: e.target.value
        });
    }

    onChangeRam(e){
        this.setState({
            ram: e.target.value
        });
    }

    onChangeImageFileName(e){
        this.setState({
            imageFileName: e.target.value
        });
    }

    savePhone(){
        var data = {
            name: this.state.name,
            manufacturer: this.state.manufacturer,
            description: this.state.description,
            color: this.state.color,
            price: this.state.price,
            screen: this.state.screen,
            processor: this.state.processor,
            ram: this.state.ram,
            imageFileName: this.state.imageFileName
        };

        PhoneDataService.create(data).then(response =>{
            this.setState({
                id: response.data.id,
                name: response.data.name,
                manufacturer: response.data.manufacturer,
                description: response.data.description,
                color: response.data.color,
                price: response.data.price,
                screen: response.data.screen,
                processor: response.data.processor,
                ram: response.data.ram,
                imageFileName: response.data.imageFileName,
                submitted: true
            });
            console.log(response.data);
        })
            .catch(e => {
                console.log(e);
            });
    }

    newPhone(){
        this.setState({
            id:null,
            name:"",
            manufacturer:"",
            description:"",
            color:"",
            price:null,
            screen:"",
            processor:"",
            ram:null,
            imageFileName:"",
            submitted:false
        });
    }

    render(){
        return(
            <div className="submit-form">
                {this.state.submitted ? (
                    <div>
                        <h4>You submitted successfully!</h4>
                        <button className="btn btn-success" onClick={this.newPhone}>
                            Add
                        </button>
                    </div>
                ) : (
                    <div>
                        <div className="form-group">
                            <label htmlFor="name">Name</label>
                            <input
                                type="text"
                                className="form-control"
                                id="name"
                                required
                                value={this.state.name}
                                onChange={this.onChangeName}
                                name="name"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="manufacturer">Manufacturer</label>
                            <input
                                type="text"
                                className="form-control"
                                id="manufacturer"
                                required
                                value={this.state.manufacturer}
                                onChange={this.onChangeManufacturer}
                                name="manufacturer"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="description">Description</label>
                            <input
                                type="text"
                                className="form-control"
                                id="description"
                                required
                                value={this.state.description}
                                onChange={this.onChangeDescription}
                                name="description"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="color">Color</label>
                            <input
                                type="text"
                                className="form-control"
                                id="color"
                                required
                                value={this.state.color}
                                onChange={this.onChangeColor}
                                name="color"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="price">Price</label>
                            <input
                                type="number"
                                className="form-control"
                                id="price"
                                required
                                value={this.state.price}
                                onChange={this.onChangePrice}
                                name="price"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="screen">Screen</label>
                            <input
                                type="text"
                                className="form-control"
                                id="screen"
                                required
                                value={this.state.screen}
                                onChange={this.onChangeScreen}
                                name="screen"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="processor">Processor</label>
                            <input
                                type="text"
                                className="form-control"
                                id="processor"
                                required
                                value={this.state.processor}
                                onChange={this.onChangeProcessor}
                                name="processor"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="ram">Ram</label>
                            <input
                                type="number"
                                className="form-control"
                                id="ram"
                                required
                                value={this.state.ram}
                                onChange={this.onChangeRam}
                                name="ram"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="imageFileName">ImageFileName</label>
                            <input
                                type="text"
                                className="form-control"
                                id="imageFileName"
                                required
                                value={this.state.imageFileName}
                                onChange={this.onChangeImageFileName}
                                name="imageFileName"
                            />
                        </div>

                        <button onClick={this.savePhone} className="btn btn-success">
                            Submit
                        </button>
                    </div>
                )}
            </div>
        );
    }
}
