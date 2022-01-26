import React from 'react';
import Button from "@material-ui/core/IconButton";
// import GitHubIcon from '@mui/icons-material/GitHub';
// import TwitterIcon from '@mui/icons-material/Twitter';


const About = () => {
    return (
        <div className="container">
            <div className="py-4">
                <h1 className="py-4" >Whats the query?</h1>
                <div style={{ display: "flex" }}>
                    
                        <Button style={{ color: "black" }} onClick={() => window.open("https://github.com/Bhartipatel123/107-BhartiPatel", '_blank')}>
                            {/* <GitHubIcon /> */}
                        </Button>
                
                    <Button style={{ color: "black" }} onClick={() => window.open("", '_blank')}>
                        {/* <TwitterIcon /> */}
                    </Button>
                    

                </div>
            </div>

        </div>
    );
};
export default About;