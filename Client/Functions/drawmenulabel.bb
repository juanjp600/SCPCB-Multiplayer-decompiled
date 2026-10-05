Function drawmenulabel%(arg0$, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    local0 = imenuscale[$28]
    local1 = ((fonts[$01]\Field3 * len(arg0)) + local0)
    local2 = imenuscale[$9F]
    local3 = imenuscale[$11E]
    local4 = local1
    local5 = imenuscale[$46]
    drawframe(local2, local3, local4, local5, $00, $00)
    If ((arg2 + arg3) = $FFFFFFFE) Then
        arg2 = imenuscale[$9F]
        arg3 = imenuscale[$11E]
    EndIf
    local6 = (local4 Shr $01)
    local7 = imenuscale[$23]
    setcolorraw(arg1)
    setfontex(fonts[$01]\Field0)
    text((arg2 + local6), (arg3 + local7), arg0, $01, $01)
    setcolorraw($FFFFFF)
    If (drawbutton(((arg2 + local4) + imenuscale[$14]), arg3, imenuscale[$64], local5, "BACK", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
        shouldexitpage = $01
    EndIf
    Return $00
End Function
