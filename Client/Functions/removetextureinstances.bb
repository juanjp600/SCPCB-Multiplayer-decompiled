Function removetextureinstances%()
    Local local0%
    Local local1%
    Local local2%
    local1 = jsongetarray(jsongetvalue(achievementsarray, "achievements"))
    local2 = jsongetarraysize(local1)
    For local0 = $00 To (local2 - $01) Step $01
        freeimage(s2imapget(achievementsimages, jsongetstring(jsongetvalue(jsongetarrayvalue(local1, local0), "id"))))
    Next
    freeimage(s2imapget(achievementsimages, "locked"))
    destroys2imap(achievementsindex)
    achievementsindex = $00
    destroys2imap(achievementsimages)
    achievementsimages = $00
    destroys2imap(unlockedachievements)
    unlockedachievements = $00
    achievementsarray = $00
    localachievementsarray = $00
    For local0 = $00 To $10 Step $01
        freeimage(t\Field0[local0])
        t\Field0[local0] = $00
    Next
    For local0 = $00 To $07 Step $01
        freeimage(t\Field1[local0])
        t\Field1[local0] = $00
    Next
    For local0 = $00 To $03 Step $01
        t\Field2[local0] = $00
    Next
    For local0 = $00 To $0A Step $01
        If (t\Field3[local0] <> $00) Then
            freeentity(t\Field3[local0])
            t\Field3[local0] = $00
        EndIf
    Next
    Delete t
    t = Null
    Return $00
End Function
