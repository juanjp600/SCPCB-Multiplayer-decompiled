Function updateexplosion%()
    Local local0%
    If (0.0 < me\Field58) Then
        me\Field58 = (me\Field58 + fps\Field7[$00])
        If (140.0 > me\Field58) Then
            If (5.0 > (me\Field58 - fps\Field7[$00])) Then
                snd_i\Field58 = loadsound_strict("SFX\Ending\GateB\Nuke0.ogg")
                playsound_strict(snd_i\Field58, $00, $01)
                me\Field24 = 10.0
                me\Field58 = 5.0
            EndIf
            me\Field24 = curvevalue((me\Field58 / 60.0), me\Field24, 50.0)
        Else
            me\Field24 = min((me\Field58 / 20.0), 20.0)
            If (140.0 > (me\Field58 - fps\Field7[$00])) Then
                me\Field10 = 1.0
                snd_i\Field58 = loadsound_strict("SFX\Ending\GateB\Nuke1.ogg")
                playsound_strict(snd_i\Field58, $00, $01)
            EndIf
            me\Field51 = min(((me\Field58 - 140.0) / 10.0), 5.0)
            If (160.0 < me\Field58) Then
                kill($00, $01, $01, $00)
            EndIf
            If (500.0 < me\Field58) Then
                me\Field58 = 0.0
            EndIf
            positionentity(me\Field60, entityx(me\Field60, $00), 200.0, entityz(me\Field60, $00), $00)
        EndIf
    EndIf
    Return $00
End Function
