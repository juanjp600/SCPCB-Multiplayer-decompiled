Function movetopocketdimension%()
    Local local0.rooms
    Local local1.events
    n_i\Field3\Field26 = 1.0
    For local0 = Each rooms
        If (local0\Field7\Field6 = $69) Then
            me\Field10 = -10.0
            me\Field3 = 0.0
            me\Field36 = 0.0
            me\Field9 = $01
            me\Field31 = (me\Field31 + 0.5)
            me\Field49 = 1750.0
            hideentity(me\Field61)
            showentity(me\Field60)
            playsound_strict(snd_i\Field28, $00, $01)
            playsound_strict(snd_i\Field45[$05], $00, $01)
            n_i\Field3\Field26 = 0.0
            teleportentity(me\Field60, entityx(local0\Field2, $00), (entityy(local0\Field2, $00) + 0.5), entityz(local0\Field2, $00), 0.3, $00, 2.0, $00)
            teleporttoroom(local0)
            For local1 = Each events
                If (local0 = local1\Field1) Then
                    local1\Field3 = 0.0
                    Exit
                EndIf
            Next
            Return $00
            Exit
        EndIf
    Next
    Return $00
End Function
