Function loadwaypoints%(arg0%)
    Local local0.doors
    Local local1.waypoints
    Local local2.waypoints
    Local local3.rooms
    Local local4.rooms
    Local local5#
    Local local6%
    Local local7#
    Local local8#
    Local local9#
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    For local0 = Each doors
        hideentity(local0\Field0)
        If (local0\Field1 <> $00) Then
            hideentity(local0\Field1)
        EndIf
        hideentity(local0\Field2)
        If (local0\Field15 = Null) Then
            local4 = Null
            local8 = 30.0
            For local3 = Each rooms
                local5 = (Abs (entityx(local3\Field2, $01) - entityx(local0\Field2, $01)))
                If (20.0 > local5) Then
                    local7 = (Abs (entityz(local3\Field2, $01) - entityz(local0\Field2, $01)))
                    If (20.0 > local7) Then
                        local9 = ((local5 * local5) + (local7 * local7))
                        If (local8 > local9) Then
                            local4 = local3
                            local8 = local9
                        EndIf
                    EndIf
                EndIf
            Next
        Else
            local4 = local0\Field15
        EndIf
        If (((local0\Field16 = $00) And (local0\Field10 <> $05)) <> 0) Then
            createwaypoint(local0, local4, entityx(local0\Field2, $01), (entityy(local0\Field2, $01) + 0.18), entityz(local0\Field2, $01))
        EndIf
    Next
    local10 = $00
    For local1 = Each waypoints
        entityradius(local1\Field0, 0.2, 0.0)
        entitypickmode(local1\Field0, $01, $01)
        local10 = (local10 + $01)
    Next
    local11 = $00
    local12 = $00
    For local1 = Each waypoints
        local11 = (local11 + $01)
        local12 = (local12 + $01)
        If (local12 = $05) Then
            renderloading((Int (floor(((35.0 / (Float local10)) * (Float local11))) + (Float arg0))), getlocalstring("loading", "waypoints"))
            local12 = $00
        EndIf
        local2 = (After local1)
        local15 = $00
        While (local2 <> Null)
            If ((((local1\Field2 = local2\Field2) Lor (local1\Field1 <> Null)) Lor (local2\Field1 <> Null)) <> 0) Then
                local8 = entitydistance(local1\Field0, local2\Field0)
                If (((0.0 = local1\Field2\Field22) Lor (0.0 = local2\Field2\Field22)) <> 0) Then
                    local15 = $01
                ElseIf (isequal(entityy(local1\Field0, $00), entityy(local2\Field0, $00), local1\Field2\Field22) <> 0) Then
                    local15 = $01
                EndIf
                If (7.0 > local8) Then
                    If (local15 <> 0) Then
                        If (entityvisible(local1\Field0, local2\Field0) <> 0) Then
                            For local13 = $00 To $04 Step $01
                                If (local1\Field4[local13] = Null) Then
                                    local1\Field4[local13] = local2
                                    local1\Field5[local13] = local8
                                    Exit
                                EndIf
                            Next
                            For local14 = $00 To $04 Step $01
                                If (local2\Field4[local14] = Null) Then
                                    local2\Field4[local14] = local1
                                    local2\Field5[local14] = local8
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
        showentity(local0\Field0)
        If (local0\Field1 <> $00) Then
            showentity(local0\Field1)
        EndIf
        showentity(local0\Field2)
    Next
    For local1 = Each waypoints
        entityradius(local1\Field0, 0.0, 0.0)
        entitypickmode(local1\Field0, $00, $00)
        If (opt\Field51 <> 0) Then
            For local13 = $00 To $04 Step $01
                If (local1\Field4[local13] <> Null) Then
                    local16 = createline(entityx(local1\Field0, $01), entityy(local1\Field0, $01), entityz(local1\Field0, $01), entityx(local1\Field4[local13]\Field0, $01), entityy(local1\Field4[local13]\Field0, $01), entityz(local1\Field4[local13]\Field0, $01), $00)
                    entitycolor(local16, 255.0, 0.0, 0.0)
                    entityparent(local16, local1\Field0, $01)
                EndIf
            Next
        EndIf
    Next
    Return $00
End Function
