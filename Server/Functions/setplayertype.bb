Function setplayertype%(arg0%, arg1%)
    player[arg0]\Field36 = arg1
    If (arg1 > $00) Then
        player[arg0]\Field61 = $00
    Else
        player[arg0]\Field61 = $01
    EndIf
    Return $00
End Function
