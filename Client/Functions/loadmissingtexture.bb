Function loadmissingtexture%()
    missingtexture = createtexture($02, $02, ((opt\Field3 Shl $08) + $01), $01)
    textureblend(missingtexture, $03)
    setbuffer(texturebuffer(missingtexture, $00))
    clscolor($00, $00, $00)
    cls()
    setbuffer(backbuffer())
    Return $00
End Function
