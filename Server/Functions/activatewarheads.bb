Function activatewarheads%(arg0$, arg1%, arg2%)
    Local local0%
    If (getscripts() <> 0) Then
        public_inqueue($32, $00)
        public_addparam($00, (Str arg2), $01)
        callback($00)
    EndIf
    gameinfo\Field5\Field3 = gameinfo\Field5\Field5
    gameinfo\Field5\Field0 = gameinfo\Field5\Field1
    gameinfo\Field5\Field1 = (millisecs() + $11170)
    gameinfo\Field5\Field5 = (millisecs() + rand($493E0, $61A80))
    gameinfo\Field5\Field7 = (millisecs() + $1D4C0)
    gameinfo\Field5\Field11 = arg0
    For local0 = $01 To server\Field11 Step $01
        breach_getcategorycolor(arg1)
        If (arg1 = $00) Then
            color($00, $00, $00)
        EndIf
        udp_writebyte($75)
        udp_writebyte($01)
        If (arg0 = "") Then
            udp_writeline(breach_getcategoryname(arg1))
        Else
            udp_writeline(arg0)
        EndIf
        udp_writebyte(colorred())
        udp_writebyte(colorgreen())
        udp_writebyte(colorblue())
        udp_writebyte((((se_getreturnvalue() = "0") Or (se_getreturnvalue() = "-1")) = $00))
        udp_sendmessage(playeroptimize[local0]\Field30)
    Next
    gameinfo\Field5\Field6 = $01
    Return $00
End Function
