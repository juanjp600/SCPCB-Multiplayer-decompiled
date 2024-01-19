Function findpath%(arg0.npcs, arg1#, arg2#, arg3#)
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6.waypoints
    Local local7.waypoints
    Local local8.waypoints
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17.waypoints
    Local local18#
    Local local19.waypoints
    Local local20.waypoints
    Local local21%
    local9 = (Int floor(((entityx(arg0\Field4, $01) / 8.0) + 0.5)))
    local10 = (Int floor(((entityz(arg0\Field4, $01) / 8.0) + 0.5)))
    local11 = (Int floor(((arg1 / 8.0) + 0.5)))
    local12 = (Int floor(((arg3 / 8.0) + 0.5)))
    For local6 = Each waypoints
        local6\Field3 = $00
        local6\Field6 = 0.0
        local6\Field7 = 0.0
        local6\Field8 = 0.0
    Next
    arg0\Field37 = $00
    arg0\Field39 = $00
    For local15 = $00 To $13 Step $01
        arg0\Field36[local15] = Null
    Next
    local16 = createpivot($00)
    positionentity(local16, arg1, arg2, arg3, $01)
    local0 = createpivot($00)
    positionentity(local0, entityx(arg0\Field4, $01), (entityy(arg0\Field4, $01) + 0.15), entityz(arg0\Field4, $01), $00)
    local1 = 350.0
    For local6 = Each waypoints
        local3 = (entityx(local6\Field0, $01) - entityx(local0, $01))
        local5 = (entityz(local6\Field0, $01) - entityz(local0, $01))
        local4 = (entityy(local6\Field0, $01) - entityy(local0, $01))
        local2 = (((local3 * local3) + (local4 * local4)) + (local5 * local5))
        If (local1 > local2) Then
            If (entityvisible(local6\Field0, local0) = $00) Then
                local2 = (local2 * 3.0)
            EndIf
            If (local1 > local2) Then
                local1 = local2
                local7 = local6
            EndIf
        EndIf
    Next
    freeentity(local0)
    If (local7 = Null) Then
        Return $02
    EndIf
    local7\Field3 = $01
    local8 = Null
    local1 = 400.0
    For local6 = Each waypoints
        local3 = (entityx(local16, $01) - entityx(local6\Field0, $01))
        local5 = (entityz(local16, $01) - entityz(local6\Field0, $01))
        local4 = (entityy(local16, $01) - entityy(local6\Field0, $01))
        local2 = (((local3 * local3) + (local4 * local4)) + (local5 * local5))
        If (local1 > local2) Then
            local1 = local2
            local8 = local6
        EndIf
    Next
    freeentity(local16)
    If (local8 = local7) Then
        If (0.4 > local1) Then
            Return $00
        Else
            arg0\Field36[$00] = local8
            Return $01
        EndIf
    EndIf
    If (local8 = Null) Then
        Return $02
    EndIf
    Repeat
        local0 = $00
        local17 = Null
        local1 = 10000.0
        For local6 = Each waypoints
            If (local6\Field3 = $01) Then
                local0 = $01
                If (local1 > local6\Field6) Then
                    local1 = local6\Field6
                    local17 = local6
                EndIf
            EndIf
        Next
        If (local17 <> Null) Then
            local6 = local17
            local6\Field3 = $02
            For local15 = $00 To $04 Step $01
                If (local6\Field4[local15] <> Null) Then
                    If (local6\Field4[local15]\Field3 < $02) Then
                        If (local6\Field4[local15]\Field3 = $01) Then
                            local18 = (local6\Field7 + local6\Field5[local15])
                            If (arg0\Field5 = $08) Then
                                If (local6\Field4[local15]\Field1 = Null) Then
                                    local18 = (local18 + 0.5)
                                EndIf
                            EndIf
                            If (local18 < local6\Field4[local15]\Field7) Then
                                local6\Field4[local15]\Field7 = local18
                                local6\Field4[local15]\Field6 = (local6\Field4[local15]\Field7 + local6\Field4[local15]\Field8)
                                local6\Field4[local15]\Field9 = local6
                            EndIf
                        Else
                            local6\Field4[local15]\Field8 = ((Abs (entityx(local6\Field4[local15]\Field0, $01) - entityx(local8\Field0, $01))) + (Abs (entityz(local6\Field4[local15]\Field0, $01) - entityz(local8\Field0, $01))))
                            local18 = (local6\Field7 + local6\Field5[local15])
                            If (arg0\Field5 = $08) Then
                                If (local6\Field4[local15]\Field1 = Null) Then
                                    local18 = (local18 + 0.5)
                                EndIf
                            EndIf
                            local6\Field4[local15]\Field7 = local18
                            local6\Field4[local15]\Field6 = (local6\Field7 + local6\Field8)
                            local6\Field4[local15]\Field9 = local6
                            local6\Field4[local15]\Field3 = $01
                        EndIf
                    EndIf
                EndIf
            Next
        ElseIf (local8\Field3 > $00) Then
            local7\Field9 = Null
            local8\Field3 = $02
            Exit
        EndIf
        If (local8\Field3 > $00) Then
            local7\Field9 = Null
            local8\Field3 = $02
            Exit
        EndIf
    Until (local0 = $00)
    If (local8\Field3 > $00) Then
        local19 = local8
        local20 = local8
        local21 = $00
        Repeat
            local21 = (local21 + $01)
            local19 = local19\Field9
            If (local21 > $14) Then
                local20 = local20\Field9
            EndIf
        Until (local19 = Null)
        local19 = local8
        While (local20 <> Null)
            local21 = (Int min((Float (local21 - $01)), 19.0))
            local20 = local20\Field9
            arg0\Field36[local21] = local20
        Wend
        Return $01
    Else
        Return $02
    EndIf
    Return $00
End Function
