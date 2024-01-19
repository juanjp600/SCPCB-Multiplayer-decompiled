Function object_update_visible%(arg0%, arg1%, arg2%)
    If (multiplayer_object[arg0]\Field13[arg1] = (arg2 = $00)) Then
        Return $00
    EndIf
    player[arg1]\Field52 = (player[arg1]\Field52 + $01)
    multiplayer_object[arg0]\Field13[arg1] = (arg2 = $00)
    Return $00
End Function
