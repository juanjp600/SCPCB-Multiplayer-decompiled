Function initachievements%()
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    Local local4$
    achievementsindex = creates2imap()
    achievementsimages = creates2imap()
    unlockedachievements = creates2imap()
    achievementsarray = jsonparsefromfile("Data\achievements.jsonc")
    localachievementsarray = jsonparsefromfile((lang\Field1 + "Data\achievements.jsonc"))
    local1 = jsongetarray(jsongetvalue(achievementsarray, "achievements"))
    local2 = jsongetarraysize(local1)
    For local0 = $00 To (local2 - $01) Step $01
        local3 = jsongetstring(jsongetvalue(jsongetarrayvalue(local1, local0), "id"))
        local4 = jsongetstring(jsongetvalue(jsongetarrayvalue(local1, local0), "image"))
        s2imapset(achievementsindex, local3, local0)
        s2imapset(achievementsimages, local3, scaleimageex(loadimage_strict(("GFX\Menu\Achievements\" + local4)), menuscale, menuscale, $01))
    Next
    s2imapset(achievementsimages, "locked", scaleimageex(loadimage_strict("GFX\Menu\Achievements\AchvLocked.png"), menuscale, menuscale, $01))
    Return $00
End Function
