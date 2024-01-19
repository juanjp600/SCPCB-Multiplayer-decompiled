Function checkobjectanimation%(arg0%)
    multiplayer_object[arg0]\Field10 = (animlength(multiplayer_object[arg0]\Field1) > $00)
    Return $00
End Function
