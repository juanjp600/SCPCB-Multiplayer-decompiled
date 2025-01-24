Function createevent.events(arg0%, arg1%, arg2%, arg3#)
    Local local0.events
    Local local1.events
    Local local2.rooms
    Local local3%
    Local local4%
    local3 = $00
    If (0.0 = arg3) Then
        For local2 = Each rooms
            If (arg1 = local2\Field7\Field6) Then
                local4 = $00
                For local1 = Each events
                    If (local1\Field1 = local2) Then
                        local4 = $01
                        Exit
                    EndIf
                Next
                local3 = (local3 + $01)
                If (((local3 >= arg2) And (local4 = $00)) <> 0) Then
                    local0 = (New events)
                    local0\Field0 = arg0
                    mp_initializeevent(local0, $FFFFFFFF)
                    findeventvariable(local0)
                    local0\Field1 = local2
                    Return local0
                EndIf
            EndIf
        Next
    Else
        For local2 = Each rooms
            If (arg1 = local2\Field7\Field6) Then
                local4 = $00
                For local1 = Each events
                    If (local1\Field1 = local2) Then
                        local4 = $01
                        Exit
                    EndIf
                Next
                If (((arg3 >= rnd(0.0, 1.0)) And (local4 = $00)) <> 0) Then
                    local0 = (New events)
                    local0\Field0 = arg0
                    mp_initializeevent(local0, $FFFFFFFF)
                    findeventvariable(local0)
                    local0\Field1 = local2
                EndIf
            EndIf
        Next
    EndIf
    Return Null
    Return Null
End Function
