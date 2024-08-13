"use client";
import { Box, Stack, TextField, Card, CardMedia, Grid } from "@mui/material";
import { useState } from "react";

export default function UserView() {
    const [vendors, setVendors] = useState([
        "Momo Hut",
        "Pizza Place",
        "KFC",
        "McD",
        "Domino's",
        "Toscanos",
        "Hopshaus",
        "in-n-out",
    ]);

    // Search functionality for Location
    const [location, setLocation] = useState("");

    // Function to handle location input change
    const handleLocationSearchChange = (e) => {
        setLocation(e.target.value);
    };

    // Search functionality for Vendor
    const [vendorSearchQuery, setVendorSearchQuery] = useState("");

    // Function to handle search input change
    const handleVendorSearchQueryChange = (e) => {
        setVendorSearchQuery(e.target.value);
    };
    const filteredVendorResults = vendors.filter((vendor) =>
        vendor.toLowerCase().includes(vendorSearchQuery.toLowerCase())
    );

    return (
        <Box
            sx={{
                backgroundColor: "#2b461c",
                minHeight: "100vh",
                fontFamily: "'Josefin Sans', sans-serif",
            }}
        >
            <Box
                width={"100%"}
                height={100}
                sx={{ border: "1px solid #a1cf6b", bgcolor: "#a1cf6b" }}
            >
                <Stack
                    width={"100%"}
                    direction={"row"}
                    spacing={2}
                    justifyContent={"space-between"}
                    alignContent={"space-between"}
                    alignItems={"center"}
                >
                    <Box>
                        <Card>
                            <CardMedia
                                component="img"
                                height="100"
                                image="/street-scout-logo.jpeg"
                                alt="description of image"
                            />
                        </Card>
                    </Box>
                    <Box
                        paddingRight={5}
                        sx={{ fontFamily: "'Josefin Sans', sans-serif" }}
                    >
                        My Account
                    </Box>
                </Stack>
            </Box>
            <Box
                width={"100%"}
                sx={{ border: "1px solid #a1cf6b", bgcolor: "#2b461c" }}
            >
                <Stack
                    width={"100%"}
                    direction={"row"}
                    spacing={2}
                    justifyContent={"space-between"}
                    alignContent={"space-between"}
                    alignItems={"center"}
                >
                    <Box
                        sx={{
                            // border: "1px solid pink",
                            width: "100%",
                            padding: 5,
                        }}
                    >
                        <h2 style={{ color: "#F3F695" }}>Location</h2>

                        <Box
                            width="80%"
                            marginBottom={2}
                            marginTop={2}
                            bgcolor={"#F3F695"}
                            borderRadius={2}
                            border={"#F3F695 0px solid"}
                        >
                            <TextField
                                fullWidth
                                label="Search Location"
                                variant="outlined"
                                value={location}
                                onChange={handleLocationSearchChange}
                                InputLabelProps={{
                                    sx: { color: "#808080" }, // Change the color to your desired value
                                }}
                            />
                        </Box>
                    </Box>
                    <Box
                        sx={{
                            // border: "1px solid pink",
                            width: "100%",
                            padding: 5,
                        }}
                    >
                        <h2 style={{ color: "#F3F695" }}>Search Vendors</h2>
                        <Box
                            width="80%"
                            marginBottom={2}
                            marginTop={2}
                            bgcolor={"#F3F695"}
                            borderRadius={2}
                            border={"#F3F695 0px solid"}
                        >
                            <TextField
                                fullWidth
                                label="Search Vendors"
                                variant="outlined"
                                value={vendorSearchQuery}
                                onChange={handleVendorSearchQueryChange}
                                InputLabelProps={{
                                    sx: { color: "#808080" },
                                }}
                            />
                        </Box>
                    </Box>
                </Stack>
                <Box padding={5} paddingBottom={20}>
                    <Grid container spacing={2}>
                        {filteredVendorResults.map((vendor) => (
                            <Grid item xs={12} sm={6} md={4} key={vendor}>
                                <Box
                                    sx={{
                                        padding: 2,
                                        border: "1px solid #ccc",
                                        borderRadius: 2,
                                        bgcolor: "#fff",
                                        textAlign: "center",
                                    }}
                                >
                                    <p>{vendor}</p>
                                </Box>
                            </Grid>
                        ))}
                    </Grid>
                </Box>
            </Box>
        </Box>
    );
}
