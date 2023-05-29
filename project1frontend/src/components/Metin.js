import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { color, Container } from '@mui/system';
import { Paper,Button, useScrollTrigger } from '@mui/material';

export default function Metin() {

    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const [text,setText]=React.useState('')
    const[metin,setMetin]=React.useState([])
    const[birlesik,setBirlesik]=React.useState([])

    const HandleMergeClick=(e)=>{
      e.preventDefault()
      const birlesik={text}
      console.log(metin)
      fetch("http://localhost:8080/birlesik/add",{
          method:"POST",
          headers:{"Content-Type":"application/json"},
          body:JSON.stringify(birlesik)

      }).then(()=>{
          console.log("New birlesik added")
      })
    }

    const handleClick=(e)=>{
        e.preventDefault()
        const metin={text}
        console.log(metin)
        fetch("http://localhost:8080/metin/add",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(metin)

        }).then(()=>{
            console.log("New text added")
        })
    }

    React.useEffect(()=>{
        fetch("http://localhost:8080/metin/getAll")
        .then(res=>res.json())
        .then((result)=>{
            setMetin(result);
        }
        )
    },[])

    React.useEffect(()=>{
      fetch("http://localhost:8080/birlesik/getAll")
      .then(res=>res.json())
      .then((result)=>{
          setBirlesik(result);
      }
      )
  },[])

  return (
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"red"}}><u>METİN EKLE</u></h1>
            <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1},
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="standard-basic" label="Metin" variant="standard" fullWidth 
      value={text}
      onChange={(e)=>setText(e.target.value)}
      />
      <Button variant="contained" color="primary" onClick={handleClick}>
        ekle
      </Button>
    </Box>
        </Paper>  

        <Paper elevation={3} style={paperStyle}>
         <h1 style={{color:"red"}}><u>METİNLER</u></h1>
          {metin.map(metin=>(
            <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={metin.id}>
              {metin.text}
              </Paper>
          ))}

       <Button variant="contained" color="primary" onClick={HandleMergeClick}>
        Birleştir
       </Button>
        </Paper>

        <Paper elevation={3} style={paperStyle}>
         <h1 style={{color:"red"}}><u>BİRLEŞİK METİN</u></h1>
         {birlesik.map(birlesik=>(
            <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={birlesik.id}>
              Birleşik Metin = {birlesik.text} <br/><br/>
              Birleştirmede Geçen Süre = {birlesik.seconds} saniye

              </Paper>
          ))}
       <Button variant="contained" color="primary" onClick={handleClick}>
        KAYDET
       </Button>
        </Paper>



    </Container>
    
  );
}
