Function createevent.events(arg0$, arg1$, arg2%, arg3#)
    Local local0%
    Local local1%
    Local local2.events
    Local local3.events
    Local local4.rooms
    local0 = $00
    If (0.0 = arg3) Then
        For local4 = Each rooms
            If (((arg1 = "") Or (arg1 = local4\Field7\Field10)) <> 0) Then
                local1 = $00
                For local3 = Each events
                    If (local3\Field1 = local4) Then
                        local1 = $01
                        Exit
                    EndIf
                Next
                local0 = (local0 + $01)
                If (((local0 >= arg2) And (local1 = $00)) <> 0) Then
                    local2 = (New events)
                    local2\Field0 = arg0
                    seteventvar(local2)
                    local2\Field1 = local4
                    local2\Field22 = findeventconst(arg0)
                    Return local2
                EndIf
            EndIf
        Next
    Else
        For local4 = Each rooms
            If (((arg1 = "") Or (arg1 = local4\Field7\Field10)) <> 0) Then
                local1 = $00
                For local3 = Each events
                    If (local3\Field1 = local4) Then
                        local1 = $01
                        Exit
                    EndIf
                Next
                If (((arg3 > rnd(0.0, 1.0)) And (local1 = $00)) <> 0) Then
                    local2 = (New events)
                    local2\Field0 = arg0
                    seteventvar(local2)
                    local2\Field22 = findeventconst(arg0)
                    local2\Field1 = local4
                EndIf
            EndIf
        Next
    EndIf
    Return Null
    Return Null
End Function
