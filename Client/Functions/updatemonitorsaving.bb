Function updatemonitorsaving%()
    Local local0.securitycams
    Local local1%
    Local local2%
    Local local3#
    If (((((((((selecteddifficulty\Field3 <> $01) Lor invopen) Lor i_294\Field0) Lor (otheropen <> Null)) Lor (d_i\Field6 <> Null)) Lor (selectedscreen <> Null)) Lor (Int me\Field0)) Lor (0.3 >= secondarylighton)) <> 0) Then
        Return $00
    EndIf
    For local0 = Each securitycams
        If ((local0\Field19 And local0\Field5) <> 0) Then
            local1 = ((6.0 > local0\Field16\Field8) Lor (playerroom = local0\Field16))
            If (local1 <> 0) Then
                If ((((local0\Field14 And (0.5 > entitydistancesquared(local0\Field4, camera))) And (grabbedentity = $00)) And (d_i\Field9 = $00)) <> 0) Then
                    handentity = local0\Field2
                    If (mo\Field0 <> 0) Then
                        sc_i\Field3 = local0
                    EndIf
                    If (sc_i\Field3 = local0) Then
                        local2 = createpivot($00)
                        local3 = clamp((15000.0 / (- me\Field5)), 20.0, 200.0)
                        positionentity(local2, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                        pointentity(local2, local0\Field2, 0.0)
                        rotateentity(me\Field60, entitypitch(me\Field60, $00), curveangle(entityyaw(local2, $00), entityyaw(me\Field60, $00), local3), 0.0, $00)
                        turnentity(local2, 90.0, 0.0, 0.0, $00)
                        camerapitch = curveangle(entitypitch(local2, $00), (camerapitch + 90.0), local3)
                        camerapitch = (camerapitch - 90.0)
                        freeentity(local2)
                        local2 = $00
                    EndIf
                ElseIf (sc_i\Field3 = local0) Then
                    sc_i\Field3 = Null
                EndIf
            ElseIf (sc_i\Field3 = local0) Then
                sc_i\Field3 = Null
            EndIf
        EndIf
    Next
    Return $00
End Function
