/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

class Customer{
    #cusId;
    #cusName;
    #cusAddress;
    #cusSalary;

    constructor(cusId, cusName, cusAddress, cusSalary) {
        this.#cusId = cusId;
        this.#cusName = cusName;
        this.#cusAddress = cusAddress;
        this.#cusSalary = cusSalary;
    }

    getCusId() {
        return this.#cusId;
    }

    setCusId(value) {
        this.#cusId = value;
    }

    getCusName() {
        return this.#cusName;
    }

    setCusName(value) {
        this.#cusName = value;
    }

    getCusAddress() {
        return this.#cusAddress;
    }

    setCusAddress(value) {
        this.#cusAddress = value;
    }

    getCusSalary() {
        return this.#cusSalary;
    }

    setCusSalary(value) {
        this.#cusSalary = value;
    }

}
