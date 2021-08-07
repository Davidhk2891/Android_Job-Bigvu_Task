BIGVU TASK (written in Kotlin)
====================================

This app shows a list of workshops from BIGVU which the user can explore by clicking 
on any workshop and going to a screen that displays all the relevant information about 
that workshop

Introduction
------------

The project uses on the first page, a RecyclerView to populate the items with the data pulled from the 
provided API. The data from the BIGVU API is fetched using Retrofit.

The project is built in a modular manner with packages organizing tasks and relevancy. There are packages for views,
viewmodels(not built yet), network logic, model adapters and utils.

The data from the API is moved from the onClick event from the list item to the Details activity using a Bundle object

The 300 milliseconds debounce on SearchView was mounted using a Handler object

Missing parts due to time constraints
---------------
- viewmodel classes for both MainActivity and WorkshopDetailsActivity
- Custom Actionbar on MainActivity
- Moving the MediaController to anchor the bottom of the ViewView and not the parent layout
- Fixing bug with the SearchView option in MainActivity

How to get started
---------------

To build this project, clone the project from this Github page. You may run it on an emulator
or USB device
