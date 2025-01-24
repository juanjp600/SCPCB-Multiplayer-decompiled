Function mp_updategui%(arg0%)
    ismultiplayerhudenabled = $00
    mp_updatedialoghud(arg0)
    mp_updatevoicehud()
    mp_updatechathud()
    mp_updateplayerslisthud()
    Return $00
End Function
