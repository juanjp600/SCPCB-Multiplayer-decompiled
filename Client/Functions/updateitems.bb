Function updateitems%()
    Local local0.items
    Local local1.items
    Local local2%
    Local local3#
    Local local4#
    Local local5#
    Local local6%
    Local local7#
    Local local8#
    Local local9%
    Local local10#
    Local local11%
    Local local12#
    catcherrors("UpdateItems()")
    local8 = 64.0
    local9 = $00
    local10 = rnd(-0.002, 0.002)
    local11 = $00
    closestitem = Null
    For local0 = Each items
        local0\Field16 = $00
        If (local0\Field15 = $00) Then
            local0\Field23 = (local0\Field23 - fps\Field7[$00])
            local0\Field11 = (local0\Field11 - fps\Field7[$00])
            If (0.0 >= local0\Field11) Then
                local0\Field10 = entitydistancesquared(camera, local0\Field2)
                local0\Field11 = 35.0
                local0\Field21 = ((local8 > local0\Field10) Lor mp_anyplayernearitem(local0))
            EndIf
            If (local0\Field21 <> 0) Then
                If (entityhidden(local0\Field2) <> 0) Then
                    showentity(local0\Field2)
                EndIf
                If (((((1.44 > local0\Field10) And ((closestitem = Null) Lor (entitydistancesquared(camera, closestitem\Field2) > local0\Field10))) And entityinview(local0\Field3, camera)) And entityvisible(local0\Field2, camera)) <> 0) Then
                    closestitem = local0
                EndIf
                If ((local0\Field24 Lor entitycollided(local0\Field2, $01)) <> 0) Then
                    local0\Field5 = 0.0
                    local0\Field24 = $01
                Else
                    If (0.0 >= local0\Field23) Then
                        entitypickmode(local0\Field2, $00, $01)
                        If (linepick(entityx(local0\Field2, $00), entityy(local0\Field2, $00), entityz(local0\Field2, $00), 0.0, -5.0, 0.0, 0.0) <> 0) Then
                            local0\Field22 = $01
                            local0\Field23 = 35.0
                        Else
                            local0\Field22 = $00
                            local0\Field23 = 70.0
                            local0\Field5 = 0.0
                        EndIf
                        entitypickmode(local0\Field2, $01, $00)
                    EndIf
                    If (35.0 >= local0\Field23) Then
                        local0\Field5 = max((local0\Field5 - (fps\Field7[$00] * 0.0004)), -0.03)
                        translateentity(local0\Field2, 0.0, (local0\Field5 * fps\Field7[$00]), 0.0, $00)
                    EndIf
                EndIf
                If ((local0\Field22 And (0.0 = local0\Field5)) <> 0) Then
                    local0\Field22 = $00
                    For local1 = Each items
                        If (((local1\Field15 = $00) And (local1 <> local0)) <> 0) Then
                            local3 = (entityx(local1\Field2, $01) - entityx(local0\Field2, $01))
                            local4 = (entityy(local1\Field2, $01) - entityy(local0\Field2, $01))
                            local5 = (entityz(local1\Field2, $01) - entityz(local0\Field2, $01))
                            local7 = ((local3 * local3) + (local5 * local5))
                            If (((0.05 > local7) And (0.25 > (Abs local4))) <> 0) Then
                                local12 = (0.05 - local7)
                                local3 = (local3 * local12)
                                local5 = (local5 * local12)
                                While (0.001 > ((Abs local3) + (Abs local5)))
                                    local3 = (local3 + local10)
                                    local5 = (local5 + local10)
                                Wend
                                translateentity(local1\Field2, local3, 0.0, local5, $00)
                                translateentity(local0\Field2, (- local3), 0.0, (- local5), $00)
                                local0\Field22 = $01
                                local1\Field22 = $01
                                local0\Field24 = $00
                                local1\Field24 = $00
                            EndIf
                        EndIf
                    Next
                EndIf
                If (-60.0 > entityy(local0\Field2, $00)) Then
                    removeitem(local0)
                    local9 = $01
                EndIf
            ElseIf (entityhidden(local0\Field2) = $00) Then
                hideentity(local0\Field2)
            EndIf
        EndIf
        If (local9 = $00) Then
            mp_updateitem(local0)
        EndIf
        local9 = $00
    Next
    If (((invopen = $00) And (otheropen = Null)) <> 0) Then
        If (closestitem <> Null) Then
            If (mo\Field0 <> 0) Then
                pickitem(closestitem, $01)
            EndIf
        EndIf
    EndIf
    catcherrors("Uncaught: UpdateItems()")
    Return $00
End Function
