Function mp_client_receiveevent%(arg0%)
    Local local0.events
    Local local1%
    Local local2%
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    local0 = mp_events[arg0]
    local1 = mp_readbyte()
    If (local0 = Null) Then
        For local2 = $00 To $02 Step $01
            If (readbool(local1, local2) <> 0) Then
                mp_readfloat()
            EndIf
        Next
        Return $00
    EndIf
    local3 = local0\Field2
    local4 = local0\Field3
    local5 = local0\Field4
    local0\Field2 = 0.0
    local0\Field3 = 0.0
    local0\Field4 = 0.0
    If (readbool(local1, $00) <> 0) Then
        local6 = mp_readfloat()
        local0\Field2 = local3
        If (local6 > local0\Field2) Then
            local0\Field2 = local6
        EndIf
    EndIf
    If (readbool(local1, $01) <> 0) Then
        local7 = mp_readfloat()
        local0\Field3 = local4
        If (local7 > local0\Field3) Then
            local0\Field3 = local7
        EndIf
    EndIf
    If (readbool(local1, $02) <> 0) Then
        local8 = mp_readfloat()
        local0\Field4 = local5
        If (local8 > local0\Field4) Then
            local0\Field4 = local8
        EndIf
    EndIf
    local0\Field25 = $01
    Return $00
End Function
