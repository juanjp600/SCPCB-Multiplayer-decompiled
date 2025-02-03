Function initializeserver%(arg0%)
    If (ue_server\Field3 <> $00) Then
        Return $02
    EndIf
    ue_server\Field3 = createudpstreamext(arg0)
    If (ue_server\Field3 = $00) Then
        Return $00
    EndIf
    setnetworkstream(mp_getsocket())
    If (arg0 <> $00) Then
        setnetworklimiter($400)
        ue_server\Field0 = $01
        mp_initvoice($FFFFFFFF, $BB80, $FFFFFC18, $800)
        ue_server\Field9 = $01
        ue_server\Field8 = $80
    Else
        setnetworklimiter($2000)
        ue_server\Field0 = $00
    EndIf
    Return $01
    Return $00
End Function
