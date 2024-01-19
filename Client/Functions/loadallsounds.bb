Function loadallsounds%()
    Local local0%
    Local local1%
    For local0 = $00 To $02 Step $01
        opendoorsfx($00, local0) = loadsound_strict((("SFX\Door\DoorOpen" + (Str (local0 + $01))) + ".ogg"))
        closedoorsfx($00, local0) = loadsound_strict((("SFX\Door\DoorClose" + (Str (local0 + $01))) + ".ogg"))
        opendoorsfx($02, local0) = loadsound_strict((("SFX\Door\Door2Open" + (Str (local0 + $01))) + ".ogg"))
        closedoorsfx($02, local0) = loadsound_strict((("SFX\Door\Door2Close" + (Str (local0 + $01))) + ".ogg"))
        opendoorsfx($03, local0) = loadsound_strict((("SFX\Door\ElevatorOpen" + (Str (local0 + $01))) + ".ogg"))
        closedoorsfx($03, local0) = loadsound_strict((("SFX\Door\ElevatorClose" + (Str (local0 + $01))) + ".ogg"))
    Next
    For local0 = $00 To $01 Step $01
        opendoorsfx($01, local0) = loadsound_strict((("SFX\Door\BigDoorOpen" + (Str (local0 + $01))) + ".ogg"))
        closedoorsfx($01, local0) = loadsound_strict((("SFX\Door\BigDoorClose" + (Str (local0 + $01))) + ".ogg"))
    Next
    buttonsfx = loadsound_strict("SFX\Interact\Button.ogg")
    local1 = loadsound_strict("SFX\General\Eating.mp3")
    keycardsfx1 = loadsound_strict("SFX\Interact\KeyCardUse1.ogg")
    keycardsfx2 = loadsound_strict("SFX\Interact\KeyCardUse2.ogg")
    buttonsfx2 = loadsound_strict("SFX\Interact\Button2.ogg")
    scannersfx1 = loadsound_strict("SFX\Interact\ScannerUse1.ogg")
    scannersfx2 = loadsound_strict("SFX\Interact\ScannerUse2.ogg")
    opendoorfastsfx = loadsound_strict("SFX\Door\DoorOpenFast.ogg")
    cautionsfx = loadsound_strict("SFX\Room\LockroomSiren.ogg")
    gatebsirensfx = loadsound_strict("SFX\Ending\GateB\Siren.ogg")
    camerasfx = loadsound_strict("SFX\General\Camera.ogg")
    stonedragsfx = loadsound_strict("SFX\SCP\173\StoneDrag.ogg")
    gunshotsfx = loadsound_strict("SFX\General\Gunshot.ogg")
    gunshot2sfx = loadsound_strict("SFX\General\Gunshot2.ogg")
    gunshot3sfx = loadsound_strict("SFX\General\BulletMiss.ogg")
    bullethitsfx = loadsound_strict("SFX\General\BulletHit.ogg")
    teslaidlesfx = loadsound_strict("SFX\Room\Tesla\Idle.ogg")
    teslaactivatesfx = loadsound_strict("SFX\Room\Tesla\WindUp.ogg")
    teslapowerupsfx = loadsound_strict("SFX\Room\Tesla\PowerUp.ogg")
    magnetupsfx = loadsound_strict("SFX\Room\106Chamber\MagnetUp.ogg")
    magnetdownsfx = loadsound_strict("SFX\Room\106Chamber\MagnetDown.ogg")
    For local0 = $00 To $03 Step $01
        decaysfx(local0) = loadsound_strict((("SFX\SCP\106\Decay" + (Str local0)) + ".ogg"))
    Next
    burstsfx = loadsound_strict("SFX\Room\TunnelBurst.ogg")
    For local0 = $00 To $02 Step $01
        rustlesfx(local0) = loadsound_strict((("SFX\SCP\372\Rustle" + (Str local0)) + ".ogg"))
    Next
    death914sfx = loadsound_strict("SFX\SCP\914\PlayerDeath.ogg")
    use914sfx = loadsound_strict("SFX\SCP\914\PlayerUse.ogg")
    For local0 = $00 To $03 Step $01
        dripsfx(local0) = loadsound_strict((("SFX\Character\D9341\BloodDrip" + (Str local0)) + ".ogg"))
    Next
    leversfx = loadsound_strict("SFX\Interact\LeverFlip.ogg")
    lightsfx = loadsound_strict("SFX\General\LightSwitch.ogg")
    buttghostsfx = loadsound_strict("SFX\SCP\Joke\789J.ogg")
    radiosfx($01, $00) = loadsound_strict("SFX\Radio\RadioAlarm.ogg")
    radiosfx($01, $01) = loadsound_strict("SFX\Radio\RadioAlarm2.ogg")
    For local0 = $00 To $08 Step $01
        radiosfx($02, local0) = loadsound_strict((("SFX\Radio\scpradio" + (Str local0)) + ".ogg"))
    Next
    radiosquelch = loadsound_strict("SFX\Radio\squelch.ogg")
    radiostatic = loadsound_strict("SFX\Radio\static.ogg")
    radiobuzz = loadsound_strict("SFX\Radio\buzz.ogg")
    elevatorbeepsfx = loadsound_strict("SFX\General\Elevator\Beep.ogg")
    elevatormovesfx = loadsound_strict("SFX\General\Elevator\Moving.ogg")
    For local0 = $00 To $03 Step $01
        picksfx(local0) = loadsound_strict((("SFX\Interact\PickItem" + (Str local0)) + ".ogg"))
    Next
    ambientsfxamount($00) = $0B
    ambientsfxamount($01) = $0B
    ambientsfxamount($02) = $0C
    ambientsfxamount($03) = $0F
    ambientsfxamount($04) = $05
    ambientsfxamount($05) = $0A
    For local0 = $00 To $02 Step $01
        oldmansfx(local0) = loadsound_strict((("SFX\SCP\106\Corrosion" + (Str (local0 + $01))) + ".ogg"))
    Next
    oldmansfx($03) = loadsound_strict("SFX\SCP\106\Laugh.ogg")
    oldmansfx($04) = loadsound_strict("SFX\SCP\106\Breathing.ogg")
    oldmansfx($05) = loadsound_strict("SFX\Room\PocketDimension\Enter.ogg")
    For local0 = $00 To $02 Step $01
        oldmansfx(($06 + local0)) = loadsound_strict((("SFX\SCP\106\WallDecay" + (Str (local0 + $01))) + ".ogg"))
    Next
    For local0 = $00 To $02 Step $01
        scp173sfx(local0) = loadsound_strict((("SFX\SCP\173\Rattle" + (Str (local0 + $01))) + ".ogg"))
    Next
    For local0 = $00 To $0C Step $01
        horrorsfx(local0) = loadsound_strict((("SFX\Horror\Horror" + (Str local0)) + ".ogg"))
    Next
    For local0 = $0E To $0F Step $01
        horrorsfx(local0) = loadsound_strict((("SFX\Horror\Horror" + (Str local0)) + ".ogg"))
    Next
    For local0 = $07 To $09 Step $01
        introsfx(local0) = loadsound_strict((("SFX\Room\Intro\Bang" + (Str (local0 - $06))) + ".ogg"))
    Next
    For local0 = $0A To $0C Step $01
        introsfx(local0) = loadsound_strict((("SFX\Room\Intro\Light" + (Str (local0 - $09))) + ".ogg"))
    Next
    introsfx($0F) = loadsound_strict("SFX\Room\Intro\173Vent.ogg")
    alarmsfx($00) = loadsound_strict("SFX\Alarm\Alarm.ogg")
    alarmsfx($02) = loadsound_strict("SFX\Alarm\Alarm3.ogg")
    alarmsfx($03) = loadsound_strict("SFX\Alarm\Alarm4.ogg")
    alarmsfx($04) = loadsound_strict("SFX\Alarm\Alarm5.ogg")
    heartbeatsfx = loadsound_strict("SFX\Character\D9341\Heartbeat.ogg")
    For local0 = $00 To $04 Step $01
        breathsfx($00, local0) = loadsound_strict((("SFX\Character\D9341\breath" + (Str local0)) + ".ogg"))
        breathsfx($01, local0) = loadsound_strict((("SFX\Character\D9341\breath" + (Str local0)) + "gas.ogg"))
    Next
    For local0 = $00 To $02 Step $01
        necksnapsfx(local0) = loadsound_strict((("SFX\SCP\173\NeckSnap" + (Str (local0 + $01))) + ".ogg"))
    Next
    For local0 = $00 To $08 Step $01
        damagesfx(local0) = loadsound_strict((("SFX\Character\D9341\Damage" + (Str (local0 + $01))) + ".ogg"))
    Next
    For local0 = $00 To $02 Step $01
        coughsfx(local0) = loadsound_strict((("SFX\Character\D9341\Cough" + (Str (local0 + $01))) + ".ogg"))
    Next
    machinesfx = loadsound_strict("SFX\SCP\914\Refining.ogg")
    apachesfx = loadsound_strict("SFX\Character\Apache\Propeller.ogg")
    For local0 = $00 To $07 Step $01
        stepsfx($00, $00, local0) = loadsound_strict((("SFX\Step\Step" + (Str (local0 + $01))) + ".ogg"))
        stepsfx($01, $00, local0) = loadsound_strict((("SFX\Step\StepMetal" + (Str (local0 + $01))) + ".ogg"))
        stepsfx($00, $01, local0) = loadsound_strict((("SFX\Step\Run" + (Str (local0 + $01))) + ".ogg"))
        stepsfx($01, $01, local0) = loadsound_strict((("SFX\Step\RunMetal" + (Str (local0 + $01))) + ".ogg"))
        If (local0 < $03) Then
            stepsfx($02, $00, local0) = loadsound_strict((("SFX\Character\MTF\Step" + (Str (local0 + $01))) + ".ogg"))
            stepsfx($03, $00, local0) = loadsound_strict((("SFX\SCP\049\Step" + (Str (local0 + $01))) + ".ogg"))
        EndIf
        If (local0 < $04) Then
            stepsfx($04, $00, local0) = loadsound_strict((("SFX\Step\SCP\StepSCP" + (Str (local0 + $01))) + ".ogg"))
        EndIf
    Next
    For local0 = $00 To $02 Step $01
        step2sfx(local0) = loadsound_strict((("SFX\Step\StepPD" + (Str (local0 + $01))) + ".ogg"))
        step2sfx((local0 + $03)) = loadsound_strict((("SFX\Step\StepForest" + (Str (local0 + $01))) + ".ogg"))
    Next
    dooropen079sfx = loadsound_strict("SFX\Door\DoorOpen079.ogg")
    doorclose079sfx = loadsound_strict("SFX\Door\DoorClose079.ogg")
    triggered096sfx = loadsound_strict("SFX\SCP\096\Triggered.ogg")
    hisssfx = loadsound_strict("SFX\General\Hiss.ogg")
    Return $00
End Function
