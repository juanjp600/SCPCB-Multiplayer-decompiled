Function updateautosave%()
    If ((((((((opt\Field37 = $00) Lor (selecteddifficulty\Field3 <> $00)) Lor (Int me\Field0)) Lor (cansave < $03)) Lor (me\Field9 = $00)) Lor me\Field56) Lor (mp_getsocket() <> $00)) <> 0) Then
        If (350.0 >= as\Field1) Then
            cancelautosave()
        EndIf
        Return $00
    EndIf
    If (0.0 >= as\Field1) Then
        as\Field0 = (as\Field0 + $01)
        If (as\Field0 >= $05) Then
            as\Field0 = $00
        EndIf
        savegame(((currsave\Field0 + "_") + (Str as\Field0)))
    Else
        as\Field1 = (as\Field1 - fps\Field7[$00])
        If (350.0 >= as\Field1) Then
            createhintmsg(format(getlocalstring("save", "autosave.in"), (Str (Int (ceil(as\Field1) / 70.0))), "%s"), 6.0, $00)
        EndIf
    EndIf
    Return $00
End Function
