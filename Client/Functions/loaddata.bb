Function loaddata%()
    Local local0$
    Local local2$
    subfile = jsonparsefromfile("Data\subtitles.jsonc")
    localsubfile = jsonparsefromfile((lang\Field1 + "Data\subtitles.jsonc"))
    subcolors = jsongetvalue(subfile, "colors")
    localsubcolors = jsongetvalue(localsubfile, "colors")
    subtitlesinit = $01
    scp1499chunks = jsongetarray(jsonparsefromfile("Data\1499chunks.jsonc"))
    subjectname = getlocalstring("misc", "subject")
    playerfallingpickdistance = 10.0
    camerazoomvalue = tan(((atan((tan((opt\Field10 / 2.0)) * (graphicwidthfloat / graphicheightfloat))) * 2.0) / 2.0))
    collisions($02, $01, $02, $02)
    collisions($02, $02, $01, $03)
    collisions($03, $01, $02, $02)
    collisions($04, $04, $01, $02)
    collisions($05, $01, $02, $02)
    loadroomtemplates("Data\rooms.ini")
    Select selecteddifficulty\Field4
        Case $00
            difficultydmgmult = 1.0
        Case $01
            difficultydmgmult = 1.15
        Case $02
            difficultydmgmult = 1.3
        Case $03
            difficultydmgmult = 1.45
    End Select
    shouldentitiesfall = $01
    hidedistance = 17.0
    coffindistance = 100.0
    quickloadpercent = $FFFFFFFF
    escapesecondstimer = 70.0
    chs = (New cheats)
    me = (New player)
    wi = (New wearableitems)
    fog = (New fogambient)
    i_005 = (New scp005)
    i_008 = (New scp008)
    i_035 = (New scp035)
    i_268 = (New scp268)
    i_294 = (New scp294)
    init294drinks()
    i_409 = (New scp409)
    i_427 = (New scp427)
    i_500 = (New scp500)
    i_714 = (New scp714)
    i_1025 = (New scp1025)
    i_1499 = (New scp1499)
    i_966 = (New scp966)
    i_1048a = (New scp1048a)
    as = (New autosave)
    msg = (New messages)
    i_zone = (New mapzones)
    bk = (New brokendoor)
    initachievements()
    loadachievementsfile()
    igm = (New ingamemenu)
    t = (New textures)
    If (selectedcustommap = Null) Then
        local0 = format(getlocalstring("menu", "new.seed2"), randomseed, "%s")
    Else
        local2 = converttoutf8(selectedcustommap\Field0)
        If (len(local2) > $0F) Then
            local0 = format(getlocalstring("menu", "new.map"), (left(local2, $0E) + ".."), "%s")
        Else
            local0 = format(getlocalstring("menu", "new.map"), local2, "%s")
        EndIf
    EndIf
    seterrormsg($08, local0)
    Return $00
End Function
