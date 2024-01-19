Function plugin_call$(arg0%, arg1$, arg2%)
    Local local0.plugin
    Local local1%
    Local local2$
    Local local3$
    local0 = plugins[arg0]
    If (local0 = Null) Then
        Return ""
    EndIf
    local1 = createbank($FF)
    If (banksize(local0\Field2) <> $00) Then
        local3 = (Str calldll(local0\Field1, arg1, local0\Field2, local1))
    Else
        local3 = (Str calldll(local0\Field1, arg1, $00, local1))
    EndIf
    plugin_clear(arg0)
    Select arg2
        Case $01
            local2 = (Str peekbyte(local1, $00))
        Case $02
            local2 = (Str peekshort(local1, $00))
        Case $03
            local2 = (Str peekint(local1, $00))
        Case $04
            local2 = (Str peekfloat(local1, $00))
        Case $05
            local2 = peekstring_work(local1, $00)
    End Select
    freebank(local1)
    If (((local2 = "") Or (local2 = "0")) <> 0) Then
        Return local3
    EndIf
    Return local2
    Return ""
End Function
