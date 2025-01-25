Function mp_initializeevent%(arg0.events, arg1%)
    Local local0%
    If (arg1 <> $FFFFFFFF) Then
        If (arg0\Field24 > $00) Then
            mp_events[arg0\Field24] = Null
        EndIf
        mp_events[arg1] = arg0
        arg0\Field24 = arg1
    Else
        For local0 = $01 To $FF Step $01
            If (mp_events[local0] = Null) Then
                mp_events[local0] = arg0
                arg0\Field24 = local0
                Exit
            EndIf
        Next
    EndIf
    Select arg0\Field0
        Case $49,$13,$39,$10,$11,$32,$42,$35,$3F,$46,$47,$0B,$43,$1B,$3E,$14,$01,$45,$48
            mp_seteventconstant(arg0, $01)
        Default
            mp_seteventconstant(arg0, $00)
    End Select
    event_hasreceive = $00
    npcs_hasreceive = $00
    Return $00
End Function
