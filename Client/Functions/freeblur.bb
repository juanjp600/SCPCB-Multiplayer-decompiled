Function freeblur%()
    arkblurtexture = $00
    freeentity(arkblurimage)
    arkblurimage = $00
    freeentity(arkblurcam)
    arkblurcam = $00
    Return $00
End Function
