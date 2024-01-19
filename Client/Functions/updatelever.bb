Function updatelever%(arg0%, arg1%)
    Local local0#
    Local local1#
    local0 = entitydistance(camera, arg0)
    entitypickmode(arg0, $00, $00)
    If (((0.8 > local0) And (arg1 = $00)) <> 0) Then
        If (((multiplayer_isascp(myplayer\Field51) = $00) Or (myplayer\Field51 = model_049)) <> 0) Then
            If (entityinview(arg0, camera) <> 0) Then
                entitypickmode(arg0, $01, $00)
                entitypick(camera, 0.65)
                If (pickedentity() = arg0) Then
                    drawhandicon = $01
                    If (mousehit1 <> 0) Then
                        grabbedentity = arg0
                    EndIf
                EndIf
                entitypickmode(arg0, $00, $00)
                local1 = entitypitch(arg0, $00)
                If ((mousedown1 Or mousehit1) <> 0) Then
                    If (grabbedentity <> $00) Then
                        If (grabbedentity = arg0) Then
                            drawhandicon = $01
                            rotateentity(grabbedentity, max(min((entitypitch(arg0, $00) + max(min((mouse_y_speed_1 * 8.0), 30.0), -30.0)), 80.0), -80.0), entityyaw(arg0, $00), 0.0, $00)
                            drawarrowicon($00) = $01
                            drawarrowicon($02) = $01
                        EndIf
                    EndIf
                EndIf
                If (75.0 < entitypitch(arg0, $01)) Then
                    If (75.0 >= local1) Then
                        playsound2(leversfx, camera, arg0, 1.0, 1.0)
                    EndIf
                ElseIf (-75.0 > entitypitch(arg0, $01)) Then
                    If (-75.0 <= local1) Then
                        playsound2(leversfx, camera, arg0, 1.0, 1.0)
                    EndIf
                EndIf
            EndIf
        EndIf
    EndIf
    If (((mousedown1 = $00) And (mousehit1 = $00)) <> 0) Then
        grabbedentity = $00
    EndIf
    If (0.0 < entitypitch(arg0, $01)) Then
        Return $01
    Else
        Return $00
    EndIf
    Return $00
End Function
