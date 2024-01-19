Function giveachievement%(arg0%, arg1%)
    Local local0%
    Local local1$
    If (achievements(arg0) <> $01) Then
        achievements(arg0) = $01
        If ((achvmsgenabled And arg1) <> 0) Then
            local0 = getinisectionlocation("Data\achievementstrings.ini", ("s" + (Str arg0)))
            local1 = getinistring2("Data\achievementstrings.ini", local0, "string1", "")
            steam_api_setachievement(getinistring2("Data\achievementstrings.ini", local0, "image", ""))
        EndIf
    EndIf
    Return $00
End Function
