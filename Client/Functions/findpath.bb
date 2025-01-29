Function findpath%(arg0.npcs, arg1#, arg2#, arg3#)
    Local local0#
    Local local1#
    Local local2#
    Local local3.waypoints
    Local local4.waypoints
    Local local5.waypoints
    Local local6.waypoints
    Local local7%
    Local local8#
    Local local9%
    Local local10%
    Local local11%
    Local local12.waypoints
    Local local13.waypoints
    Local local14%
    arg0\Field40 = $00
    arg0\Field42 = $00
    For local7 = $00 To $14 Step $01
        arg0\Field39[local7] = Null
    Next
    local9 = createpivot($00)
    positionentity(local9, arg1, arg2, arg3, $01)
    local10 = createpivot($00)
    positionentity(local10, entityx(arg0\Field3, $01), (entityy(arg0\Field3, $01) + 0.15), entityz(arg0\Field3, $01), $00)
    local0 = 350.0
    local1 = 400.0
    For local3 = Each waypoints
        local3\Field3 = $00
        local3\Field6 = 0.0
        local3\Field7 = 0.0
        local3\Field8 = 0.0
        local2 = entitydistancesquared(local3\Field0, local10)
        If (local0 > local2) Then
            If (entityvisible(local3\Field0, local10) = $00) Then
                local2 = (local2 * 3.0)
            EndIf
            If (local0 > local2) Then
                local0 = local2
                local4 = local3
            EndIf
        EndIf
        local2 = entitydistancesquared(local9, local3\Field0)
        If (local1 > local2) Then
            local1 = local2
            local5 = local3
        EndIf
    Next
    freeentity(local9)
    local9 = $00
    freeentity(local10)
    local10 = $00
    If (((local4 = Null) Lor (local5 = Null)) <> 0) Then
        Return $02
    EndIf
    local4\Field3 = $01
    If (local5 = local4) Then
        If (0.4 > local1) Then
            Return $00
        Else
            arg0\Field39[$00] = local5
            Return $01
        EndIf
    EndIf
    Repeat
        local11 = $00
        local6 = Null
        local2 = 10000.0
        For local3 = Each waypoints
            If (local3\Field3 = $01) Then
                local11 = $01
                If (local2 > local3\Field6) Then
                    local2 = local3\Field6
                    local6 = local3
                EndIf
            EndIf
        Next
        If (local6 <> Null) Then
            local3 = local6
            local3\Field3 = $02
            For local7 = $00 To $04 Step $01
                If (local3\Field4[local7] <> Null) Then
                    If (local3\Field4[local7]\Field3 < $02) Then
                        If (local3\Field4[local7]\Field3 = $01) Then
                            local8 = (local3\Field7 + local3\Field5[local7])
                            If (arg0\Field4 = $15) Then
                                If (local3\Field4[local7]\Field1 = Null) Then
                                    local8 = (local8 + 0.5)
                                EndIf
                            EndIf
                            If (local8 < local3\Field4[local7]\Field7) Then
                                local3\Field4[local7]\Field7 = local8
                                local3\Field4[local7]\Field6 = (local3\Field4[local7]\Field7 + local3\Field4[local7]\Field8)
                                local3\Field4[local7]\Field9 = local3
                            EndIf
                        Else
                            local3\Field4[local7]\Field8 = ((Abs (entityx(local3\Field4[local7]\Field0, $01) - entityx(local5\Field0, $01))) + (Abs (entityz(local3\Field4[local7]\Field0, $01) - entityz(local5\Field0, $01))))
                            local8 = (local3\Field7 + local3\Field5[local7])
                            If (arg0\Field4 = $15) Then
                                If (local3\Field4[local7]\Field1 = Null) Then
                                    local8 = (local8 + 0.5)
                                EndIf
                            EndIf
                            local3\Field4[local7]\Field7 = local8
                            local3\Field4[local7]\Field6 = (local3\Field7 + local3\Field8)
                            local3\Field4[local7]\Field9 = local3
                            local3\Field4[local7]\Field3 = $01
                        EndIf
                    EndIf
                EndIf
            Next
        ElseIf (local5\Field3 > $00) Then
            local4\Field9 = Null
            local5\Field3 = $02
            Exit
        EndIf
        If (local5\Field3 > $00) Then
            local4\Field9 = Null
            local5\Field3 = $02
            Exit
        EndIf
    Until (local11 = $00)
    If (local5\Field3 > $00) Then
        local12 = local5
        local13 = local5
        local14 = $00
        Repeat
            local14 = (local14 + $01)
            local12 = local12\Field9
            If (local14 > $14) Then
                local13 = local13\Field9
            EndIf
        Until (local12 = Null)
        local12 = local5
        While (local13 <> Null)
            local14 = (Int min((Float (local14 - $01)), 20.0))
            local13 = local13\Field9
            arg0\Field39[local14] = local13
        Wend
        Return $01
    Else
        Return $02
    EndIf
    Return $00
End Function
