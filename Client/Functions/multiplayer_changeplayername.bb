Function multiplayer_changeplayername%(arg0%, arg1$, arg2$)
    If (player[arg0]\Field25[$00] <> $00) Then
        freeentity(player[arg0]\Field25[$00])
    EndIf
    If (player[arg0]\Field25[$03] <> $00) Then
        freeentity(player[arg0]\Field25[$03])
    EndIf
    player[arg0]\Field24 = arg1
    player[arg0]\Field86 = arg2
    setfontex(fonts[$06]\Field0)
    player[arg0]\Field25[$00] = createtextlabel(arg1, 0.001)
    If (arg2 <> "") Then
        player[arg0]\Field25[$03] = createtextlabel(arg2, 0.0005)
    EndIf
    Return $00
End Function
