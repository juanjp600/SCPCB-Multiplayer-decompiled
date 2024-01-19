Function setplayertype%(arg0%, arg1%)
    player[arg0]\Field36 = arg1
    If (arg1 > $00) Then
        player[arg0]\Field59 = $00
    Else
        player[arg0]\Field59 = $01
    EndIf
    Return $00
End Function
