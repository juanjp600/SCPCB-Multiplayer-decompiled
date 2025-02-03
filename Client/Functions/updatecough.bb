Function updatecough%(arg0%)
    If (0.0 = me\Field0) Then
        If (rand(arg0, $01) = $01) Then
            If (channelplaying(coughchn) = $00) Then
                coughchn = playsound_strict(coughsfx((((wi\Field0 > $00) Lor (i_1499\Field0 > $00)) Lor (wi\Field2 > $00)), rand($00, $02)), $01, $01)
                me\Field42 = max(4.0, me\Field42)
            EndIf
        EndIf
    EndIf
    If (channelplaying(coughchn) <> 0) Then
        stopbreathsound()
    EndIf
    Return $00
End Function
