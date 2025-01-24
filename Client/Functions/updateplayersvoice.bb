Function updateplayersvoice%()
    Local local0%
    Local local1.mp_player
    local0 = mp_gettimer()
    For local1 = Each mp_player
        bass_channelsetattribute(local1\Field36\Field0[$00], $02, (max((1.0 - (entitydistance(local1\Field18, camera) / 13.0)), 0.0) * opt\Field21))
        bass_channelset3dposition(local1\Field36\Field0[$00], entityx(local1\Field18, $00), entityy(local1\Field18, $00), entityz(local1\Field18, $00))
        bass_channelsetattribute(local1\Field36\Field0[$00], $02, opt\Field21)
        If (local1\Field36\Field3 < local0) Then
            setplayertagtext(local1, $01, "")
        EndIf
    Next
    bass_update3dlistener(camera)
    bass_apply3d()
    Return $00
End Function
