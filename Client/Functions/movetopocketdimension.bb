Function movetopocketdimension%()
    Local local0.rooms
    For local0 = Each rooms
        If (local0\Field7\Field11 = "pocketdimension") Then
            falltimer = 0.0
            updatedoors()
            updaterooms()
            showentity(collider)
            playsound_strict(use914sfx)
            playsound_strict(oldmansfx($05))
            positionentity(collider, entityx(local0\Field2, $00), 0.8, entityz(local0\Field2, $00), $00)
            dropspeed = 0.0
            resetentity(collider)
            blinktimer = -10.0
            injuries = (injuries + 0.5)
            playerroom = local0
            Return $00
        EndIf
    Next
    Return $00
End Function
