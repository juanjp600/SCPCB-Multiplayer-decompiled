Function mp_renderterminatedgui%()
    If (((Int me\Field0) And (me\Field43 = $FFFFFFFF)) <> 0) Then
        If (mp_terminated\Field5 <> $00) Then
            setfontex(fo\Field0[$00])
            textex(mo\Field9, (Int ((Float opt\Field50) - (30.0 * menuscale))), (("YOU WILL RESPAWN IN " + (Str ((Int max((Float ((mp_terminated\Field3 - millisecs()) / $3E8)), 0.0)) + $01))) + " SECONDS"), $01, $00)
        EndIf
    EndIf
    Return $00
End Function
