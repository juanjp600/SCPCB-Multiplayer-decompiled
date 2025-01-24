Function findpath%(arg0.npcs, arg1#, arg2#, arg3#)
    Local local0#
    Local local1#
    Local local2.waypoints
    Local local3.waypoints
    Local local4.waypoints
    Local local5.waypoints
    Local local6%
    Local local7#
    Local local8%
    Local local9%
    Local local10%
    Local local11.waypoints
    Local local12.waypoints
    Local local13%
    For local2 = Each waypoints
        local2\Field3 = $00
        local2\Field6 = 0.0
        local2\Field7 = 0.0
        local2\Field8 = 0.0
    Next
    arg0\Field40 = $00
    arg0\Field42 = $00
    For local6 = $00 To $14 Step $01
        arg0\Field39[local6] = Null
    Next
    local8 = createpivot($00)
    positionentity(local8, arg1, arg2, arg3, $01)
    local9 = createpivot($00)
    positionentity(local9, entityx(arg0\Field3, $01), (entityy(arg0\Field3, $01) + 0.15), entityz(arg0\Field3, $01), $00)
    local0 = 350.0
    For local2 = Each waypoints
        local1 = entitydistancesquared(local2\Field0, local9)
        If (local0 > local1) Then
            If (entityvisible(local2\Field0, local9) = $00) Then
                local1 = (local1 * 3.0)
            EndIf
            If (local0 > local1) Then
                local0 = local1
                local3 = local2
            EndIf
        EndIf
    Next
    freeentity(local9)
    local9 = $00
    If (local3 = Null) Then
        freeentity(local8)
        local8 = $00
        Return $02
    EndIf
    local3\Field3 = $01
    local4 = Null
    local0 = 400.0
    For local2 = Each waypoints
        local1 = entitydistancesquared(local8, local2\Field0)
        If (local0 > local1) Then
            local0 = local1
            local4 = local2
        EndIf
    Next
    freeentity(local8)
    local8 = $00
    If (local4 = local3) Then
        If (0.4 > local0) Then
            Return $00
        Else
            arg0\Field39[$00] = local4
            Return $01
        EndIf
    EndIf
    If (local4 = Null) Then
        Return $02
    EndIf
    Repeat
        local10 = $00
        local5 = Null
        local0 = 10000.0
        For local2 = Each waypoints
            If (local2\Field3 = $01) Then
                local10 = $01
                If (local0 > local2\Field6) Then
                    local0 = local2\Field6
                    local5 = local2
                EndIf
            EndIf
        Next
        If (local5 <> Null) Then
            local2 = local5
            local2\Field3 = $02
            For local6 = $00 To $04 Step $01
                If (local2\Field4[local6] <> Null) Then
                    If (local2\Field4[local6]\Field3 < $02) Then
                        If (local2\Field4[local6]\Field3 = $01) Then
                            local7 = (local2\Field7 + local2\Field5[local6])
                            If (arg0\Field4 = $15) Then
                                If (local2\Field4[local6]\Field1 = Null) Then
                                    local7 = (local7 + 0.5)
                                EndIf
                            EndIf
                            If (local7 < local2\Field4[local6]\Field7) Then
                                local2\Field4[local6]\Field7 = local7
                                local2\Field4[local6]\Field6 = (local2\Field4[local6]\Field7 + local2\Field4[local6]\Field8)
                                local2\Field4[local6]\Field9 = local2
                            EndIf
                        Else
                            local2\Field4[local6]\Field8 = ((Abs (entityx(local2\Field4[local6]\Field0, $01) - entityx(local4\Field0, $01))) + (Abs (entityz(local2\Field4[local6]\Field0, $01) - entityz(local4\Field0, $01))))
                            local7 = (local2\Field7 + local2\Field5[local6])
                            If (arg0\Field4 = $15) Then
                                If (local2\Field4[local6]\Field1 = Null) Then
                                    local7 = (local7 + 0.5)
                                EndIf
                            EndIf
                            local2\Field4[local6]\Field7 = local7
                            local2\Field4[local6]\Field6 = (local2\Field7 + local2\Field8)
                            local2\Field4[local6]\Field9 = local2
                            local2\Field4[local6]\Field3 = $01
                        EndIf
                    EndIf
                EndIf
            Next
        ElseIf (local4\Field3 > $00) Then
            local3\Field9 = Null
            local4\Field3 = $02
            Exit
        EndIf
        If (local4\Field3 > $00) Then
            local3\Field9 = Null
            local4\Field3 = $02
            Exit
        EndIf
    Until (local10 = $00)
    If (local4\Field3 > $00) Then
        local11 = local4
        local12 = local4
        local13 = $00
        Repeat
            local13 = (local13 + $01)
            local11 = local11\Field9
            If (local13 > $14) Then
                local12 = local12\Field9
            EndIf
        Until (local11 = Null)
        local11 = local4
        While (local12 <> Null)
            local13 = (Int min((Float (local13 - $01)), 20.0))
            local12 = local12\Field9
            arg0\Field39[local13] = local12
        Wend
        Return $01
    Else
        Return $02
    EndIf
    Return $00
End Function
