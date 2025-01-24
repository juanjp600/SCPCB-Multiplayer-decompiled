Function removenpc%(arg0.npcs)
    If (arg0 = Null) Then
        Return $00
    EndIf
    catcherrors("RemoveNPC()")
    arg0\Field34 = Null
    If (arg0\Field21 <> 0) Then
        If (arg0\Field18 <> $00) Then
            stopstream_strict(arg0\Field18)
            arg0\Field21 = $00
        EndIf
    Else
        stopchannel(arg0\Field18)
    EndIf
    arg0\Field18 = $00
    If (arg0\Field22 <> 0) Then
        If (arg0\Field20 <> $00) Then
            stopstream_strict(arg0\Field20)
            arg0\Field22 = $00
        EndIf
    Else
        stopchannel(arg0\Field20)
    EndIf
    arg0\Field20 = $00
    If (arg0\Field17 <> $00) Then
        freesound_strict(arg0\Field17)
        arg0\Field17 = $00
    EndIf
    If (arg0\Field19 <> $00) Then
        freesound_strict(arg0\Field19)
        arg0\Field19 = $00
    EndIf
    If (arg0\Field1 <> $00) Then
        freeentity(arg0\Field1)
        arg0\Field1 = $00
    EndIf
    If (arg0\Field2 <> $00) Then
        freeentity(arg0\Field2)
        arg0\Field2 = $00
    EndIf
    freeentity(arg0\Field3)
    arg0\Field3 = $00
    freeentity(arg0\Field0)
    arg0\Field0 = $00
    Delete arg0
    catcherrors("Uncaught: RemoveNPC()")
    Return $00
End Function
