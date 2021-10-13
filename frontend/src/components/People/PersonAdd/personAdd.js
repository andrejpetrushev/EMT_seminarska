import React from 'react';
import {useHistory} from 'react-router-dom';

const PersonAdd = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        personName: "",
        personSurname: "",
        personAge: 0,
        personPhoneNumber: 0,
        personAddress: "",
        rating: 0,
        purchases: 0
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    };

    const onFormSubmit = (e) => {
        e.preventDefault();
        const personName = formData.personName;
        const personSurname = formData.personSurname;
        const personAge = formData.personAge;
        const personPhoneNumber = formData.personPhoneNumber;
        const personAddress = formData.personAddress;
        const rating = formData.rating;
        const purchases = formData.purchases;

        props.onAddPerson(personName, personSurname, personAge, personPhoneNumber, personAddress, rating, purchases);
        history.push("/people");
    };

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Person name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter person name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="surname">Person surname</label>
                        <input type="text"
                               className="form-control"
                               id="surname"
                               name="surname"
                               placeholder="Enter person surname"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="age">Person age</label>
                        <input type="text"
                               className="form-control"
                               id="age"
                               name="age"
                               placeholder="Enter person age"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="phoneNumber">Person phone number</label>
                        <input type="text"
                               className="form-control"
                               id="phoneNumber"
                               name="phoneNumber"
                               placeholder="Enter phone number"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="address">Person address</label>
                        <input type="text"
                               className="form-control"
                               id="address"
                               name="address"
                               placeholder="Enter person address"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="rating">Rating</label>
                        <input type="text"
                               className="form-control"
                               id="rating"
                               name="rating"
                               placeholder="Enter rating"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="purchases">Purchases</label>
                        <input type="text"
                               className="form-control"
                               id="purchases"
                               name="purchases"
                               placeholder="Enter purchases"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Role</label>
                        <select name="role" className="form-control" onChange={handleChange}>
                            {props.roles.map((term) =>
                                <option value={term.id}>{term.roleState}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Staff</label>
                        <select name="staff" className="form-control" onChange={handleChange}>
                            {props.staff.map((term) =>
                                <option value={term.id}>{term.name}</option>
                            )}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
};

export default PersonAdd;
