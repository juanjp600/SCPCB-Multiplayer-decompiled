Function updatemonitorsaving%()
    Local local0.securitycams
    Local local1%
    Local local2%
    local1 = $00
    If (selecteddifficulty\Field4 <> $02) Then
        Return $00
    EndIf
    For local0 = Each securitycams
        If ((local0\Field23 And local0\Field7) <> 0) Then
            local1 = local0\Field20\Field69
            If (((local1 And (grabbedentity = $00)) And (closestbutton = $00)) <> 0) Then
                If ((entityinview(local0\Field4, camera) And (1.0 > entitydistance(local0\Field4, camera))) <> 0) Then
                    If (entityvisible(local0\Field4, camera) <> 0) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            selectedmonitor = local0
                        EndIf
                    ElseIf (selectedmonitor = local0) Then
                        selectedmonitor = Null
                    EndIf
                ElseIf (selectedmonitor = local0) Then
                    selectedmonitor = Null
                EndIf
                If (selectedmonitor = local0) Then
                    If (local0\Field17 <> 0) Then
                        local2 = createpivot($00)
                        positionentity(local2, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                        pointentity(local2, local0\Field4, 0.0)
                        rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local2, $00), entityyaw(collider, $00), min(max((15000.0 / (- sanity)), 20.0), 200.0)), 0.0, $00)
                        turnentity(local2, 90.0, 0.0, 0.0, $00)
                        user_camera_pitch = curveangle(entitypitch(local2, $00), (user_camera_pitch + 90.0), min(max((15000.0 / (- sanity)), 20.0), 200.0))
                        user_camera_pitch = (user_camera_pitch - 90.0)
                        freeentity(local2)
                    EndIf
                EndIf
            ElseIf (selectedmonitor = local0) Then
                selectedmonitor = Null
            EndIf
        EndIf
    Next
    Return $00
End Function
