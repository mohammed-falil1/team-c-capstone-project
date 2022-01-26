import React,{useState} from 'react';
// import ReactDOM from 'react-dom';
import "../Components/BillerRegister.css"
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import InputLabel from '@mui/material/InputLabel';
import Select from '@mui/material/Select';
import Container from '@mui/material/Container';
import FormControl from '@mui/material/FormControl';
import {Navbar,Nav} from "react-bootstrap";
import{Link} from "react-router-dom";




function BillerRegister() {
    const [billerName, setBillerName] = useState('')
    const [consumerNumber, setConsumerNumber] = useState('')
    const [registry]=useState('')

    const handleClick = (e)=>{
        e.preventDefault()
        const customer = {billerName,consumerNumber}
        console.log(registry)
        fetch("http://localhost:8080/registry/register/",{
            method: "POST",
            headers: {"Content-Type":"application/json"},
            body:JSON.stringify(customer)
        }).then (() => {
            alert("Biller Registered Succesfully. go to Biller Provider Page...")
        })
    }
  
  return (

    <Container className="registry">
    <div className="registry-field">
    <Navbar bg="dark" variant="dark">
    <Container>
    <Navbar.Brand href="#">ACCOUNT MANAGEMENT SYSTEM</Navbar.Brand>
    <Nav className="me-auto">
      <Nav.Link href="#" >Biller Provider</Nav.Link>
      <Nav.Link href="#">Biller Statement</Nav.Link>
    </Nav>
    </Container>
  </Navbar>
    <Box id="biller-Select">
    <FormControl variant="filled" sx={{ m: 1, minWidth: 120 }}>
        <InputLabel >Billers</InputLabel>
        <Select
          labelId="demo-simple-select-filled-label"
          id="demo-simple-select-filled"
          fullWidth value={billerName} onChange={(e)=>setBillerName(e.target.value)}
        >
          <MenuItem value="">
            <em>None</em>
          </MenuItem>
          <MenuItem value={"Airtel"}>Airtel</MenuItem>
          <MenuItem value={"Jio"}>Jio</MenuItem>
          <MenuItem value={"Vi"}>Vi</MenuItem>
        </Select>
      </FormControl>
    </Box>
    <Box id="cons-number">
      <TextField
        required
        label="Consumer Number"
        defaultValue=""
        placeholder='001'
        value={consumerNumber} 
        onChange={(e)=>setConsumerNumber(e.target.value)}
      />
    </Box><br></br>
      <Button variant="contained" onClick={handleClick}>Register</Button>
      <br></br>
      </div>
      </Container>
  )
    }

export default BillerRegister;