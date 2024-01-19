Function initwaypoints%(arg0%)
    Local local0.doors
    Local local1.waypoints
    Local local2.waypoints
    Local local3.rooms
    Local local4.rooms
    Local local5#
    Local local6%
    Local local7#
    Local local8%
    Local local9#
    Local local10#
    Local local11#
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    local8 = millisecs()
    For local0 = Each doors
        If (local0\Field0 <> $00) Then
            hideentity(local0\Field0)
        EndIf
        If (local0\Field1 <> $00) Then
            hideentity(local0\Field1)
        EndIf
        If (local0\Field2 <> $00) Then
            hideentity(local0\Field2)
        EndIf
        If (local0\Field13 = Null) Then
            local4 = Null
            local9 = 30.0
            For local3 = Each rooms
                local5 = (Abs (entityx(local3\Field2, $01) - entityx(local0\Field2, $01)))
                If (20.0 > local5) Then
                    local7 = (Abs (entityz(local3\Field2, $01) - entityz(local0\Field2, $01)))
                    If (20.0 > local7) Then
                        local10 = ((local5 * local5) + (local7 * local7))
                        If (local9 > local10) Then
                            local4 = local3
                            local9 = local10
                        EndIf
                    EndIf
                EndIf
            Next
        Else
            local4 = local0\Field13
        EndIf
        If (local0\Field14 = $00) Then
            createwaypoint(entityx(local0\Field2, $01), (entityy(local0\Field2, $01) + 0.18), entityz(local0\Field2, $01), local0, local4)
        EndIf
    Next
    local11 = 0.0
    For local1 = Each waypoints
        entitypickmode(local1\Field0, $01, $01)
        entityradius(local1\Field0, 0.2, 0.0)
        local11 = (local11 + 1.0)
    Next
    local12 = $00
    local13 = $00
    For local1 = Each waypoints
        local12 = (local12 + $01)
        local13 = (local13 + $01)
        If (local13 = $14) Then
            drawloading((floor(((35.0 / local11) * (Float local12))) + (Float arg0)), $00, $00, $00)
            local13 = $00
        EndIf
        local2 = (After local1)
        local14 = $00
        While (local2 <> Null)
            If ((((local1\Field2 = local2\Field2) Or (local1\Field1 <> Null)) Or (local2\Field1 <> Null)) <> 0) Then
                local9 = entitydistance(local1\Field0, local2\Field0)
                If (((0.0 = local1\Field2\Field52) Or (0.0 = local2\Field2\Field52)) <> 0) Then
                    local14 = $01
                ElseIf (local1\Field2\Field52 >= (Abs (entityy(local1\Field0, $00) - entityy(local2\Field0, $00)))) Then
                    local14 = $01
                EndIf
                If (7.0 > local9) Then
                    If (local14 <> 0) Then
                        If (entityvisible(local1\Field0, local2\Field0) <> 0) Then
                            For local15 = $00 To $04 Step $01
                                If (local1\Field4[local15] = Null) Then
                                    local1\Field4[local15] = local2
                                    local1\Field5[local15] = local9
                                    Exit
                                EndIf
                            Next
                            For local16 = $00 To $04 Step $01
                                If (local2\Field4[local16] = Null) Then
                                    local2\Field4[local16] = local1
                                    local2\Field5[local16] = local9
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                EndIf
            EndIf
            local2 = (After local2)
        Wend
    Next
    For local0 = Each doors
        If (local0\Field0 <> $00) Then
            showentity(local0\Field0)
        EndIf
        If (local0\Field1 <> $00) Then
            showentity(local0\Field1)
        EndIf
        If (local0\Field2 <> $00) Then
            showentity(local0\Field2)
        EndIf
    Next
    For local1 = Each waypoints
        entitypickmode(local1\Field0, $00, $00)
        entityradius(local1\Field0, 0.0, 0.0)
        For local15 = $00 To $04 Step $01
            If (local1\Field4[local15] <> Null) Then
                local17 = createline(entityx(local1\Field0, $01), entityy(local1\Field0, $01), entityz(local1\Field0, $01), entityx(local1\Field4[local15]\Field0, $01), entityy(local1\Field4[local15]\Field0, $01), entityz(local1\Field4[local15]\Field0, $01), $00)
                entitycolor(local17, 255.0, 0.0, 0.0)
                entityparent(local17, local1\Field0, $01)
            EndIf
        Next
    Next
    debuglog(("InitWaypoints() - " + (Str (millisecs2() - local8))))
    For local3 = Each rooms
        local3\Field69 = $01
        initadjacentroomdoors(local3)
        hideroomwithcollision(local3)
        hideroomlights(local3)
        hideroomdoors(local3, Null, $01)
        hideentity(local3\Field2)
    Next
    Return $00
End Function
