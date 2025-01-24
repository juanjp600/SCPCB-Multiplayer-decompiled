Function loadsounds%()
    Local local0%
    renderloading($2D, getlocalstring("loading", "sounds"))
    snd_i = (New soundinstance)
    snd_i\Field1[$00] = loadsound_strict("SFX\Door\DoorDecayOpen.ogg")
    snd_i\Field0[$00] = loadsound_strict("SFX\Door\DoorDecayClose.ogg")
    snd_i\Field1[$01] = loadsound_strict("SFX\Door\DoorDecayOpen.ogg")
    snd_i\Field0[$01] = loadsound_strict("SFX\Door\DoorDecayClose.ogg")
    snd_i\Field1[$02] = loadsound_strict("SFX\Door\Door2DecayOpen.ogg")
    snd_i\Field0[$02] = loadsound_strict("SFX\Door\Door2DecayClose.ogg")
    For local0 = $00 To $0D Step $01
        If (local0 < $02) Then
            snd_i\Field5[local0] = loadsound_strict((("SFX\Interact\KeyCardUse" + (Str local0)) + ".ogg"))
            snd_i\Field6[local0] = loadsound_strict((("SFX\Interact\ScannerUse" + (Str local0)) + ".ogg"))
            snd_i\Field7[local0] = loadsound_strict((("SFX\Interact\DoorBudge" + (Str local0)) + ".ogg"))
            snd_i\Field13[local0] = loadsound_strict((("SFX\Character\Gunshot" + (Str local0)) + ".ogg"))
            snd_i\Field26[local0] = loadsound_strict((("SFX\Room\Hiss" + (Str local0)) + ".ogg"))
            radiosfx($00, local0) = loadsound_strict((("SFX\Radio\RadioAlarm" + (Str local0)) + ".ogg"))
            snd_i\Field41[local0] = loadsound_strict((("SFX\Interact\LowBattery" + (Str local0)) + ".ogg"))
            snd_i\Field31[local0] = loadsound_strict((("SFX\Room\914Chamber\Knob" + (Str local0)) + ".ogg"))
            stepsfx($05, $00, local0) = loadsound_strict((("SFX\Step\StepFluid" + (Str local0)) + ".ogg"))
        EndIf
        If (local0 < $03) Then
            opendoorsfx($00, local0) = loadsound_strict((("SFX\Door\DoorOpen" + (Str local0)) + ".ogg"))
            closedoorsfx($00, local0) = loadsound_strict((("SFX\Door\DoorClose" + (Str local0)) + ".ogg"))
            opendoorsfx($01, local0) = loadsound_strict((("SFX\Door\ElevatorOpen" + (Str local0)) + ".ogg"))
            closedoorsfx($01, local0) = loadsound_strict((("SFX\Door\ElevatorClose" + (Str local0)) + ".ogg"))
            opendoorsfx($02, local0) = loadsound_strict((("SFX\Door\Door2Open" + (Str local0)) + ".ogg"))
            closedoorsfx($02, local0) = loadsound_strict((("SFX\Door\Door2Close" + (Str local0)) + ".ogg"))
            opendoorsfx($03, local0) = loadsound_strict((("SFX\Door\BigDoorOpen" + (Str local0)) + ".ogg"))
            closedoorsfx($03, local0) = loadsound_strict((("SFX\Door\BigDoorClose" + (Str local0)) + ".ogg"))
            opendoorsfx($04, local0) = loadsound_strict((("SFX\Door\OfficeDoorOpen" + (Str local0)) + ".ogg"))
            opendoorsfx($05, local0) = loadsound_strict((("SFX\Door\WoodenDoorOpen" + (Str local0)) + ".ogg"))
            snd_i\Field2[local0] = loadsound_strict((("SFX\Door\BigDoorError" + (Str local0)) + ".ogg"))
            snd_i\Field53[local0] = loadsound_strict((("SFX\SCP\173\NeckSnap" + (Str local0)) + ".ogg"))
            coughsfx($00, local0) = loadsound_strict((("SFX\Character\D9341\Cough" + (Str local0)) + ".ogg"))
            coughsfx($01, local0) = loadsound_strict((("SFX\Character\D9341\Cough" + (Str local0)) + "Gas.ogg"))
            snd_i\Field45[local0] = loadsound_strict((("SFX\SCP\106\Corrosion" + (Str local0)) + ".ogg"))
            snd_i\Field45[(local0 + $06)] = loadsound_strict((("SFX\SCP\106\WallDecay" + (Str local0)) + ".ogg"))
            snd_i\Field46[local0] = loadsound_strict((("SFX\SCP\173\Rattle" + (Str local0)) + ".ogg"))
            snd_i\Field33[local0] = loadsound_strict((("SFX\Room\Light" + (Str local0)) + ".ogg"))
            stepsfx($02, $00, local0) = loadsound_strict((("SFX\Step\StepPD" + (Str local0)) + ".ogg"))
            stepsfx($03, $00, local0) = loadsound_strict((("SFX\Step\StepCloth" + (Str local0)) + ".ogg"))
            stepsfx($04, $00, local0) = loadsound_strict((("SFX\Step\StepForest" + (Str local0)) + ".ogg"))
        EndIf
        If (local0 < $04) Then
            snd_i\Field24[local0] = loadsound_strict((("SFX\SCP\106\Decay" + (Str local0)) + ".ogg"))
            snd_i\Field30[local0] = loadsound_strict((("SFX\Character\D9341\BloodDrip" + (Str local0)) + ".ogg"))
            snd_i\Field44[local0] = loadsound_strict((("SFX\Interact\PickItem" + (Str local0)) + ".ogg"))
            snd_i\Field50[local0] = loadsound_strict((("SFX\Alarm\Alarm" + (Str local0)) + ".ogg"))
            snd_i\Field56[(local0 + $03)] = loadsound_strict((("SFX\Step\NPCs\939_966\StepMetal" + (Str local0)) + ".ogg"))
            If (local0 < $03) Then
                snd_i\Field56[local0] = loadsound_strict((("SFX\Step\NPCs\MTF\StepMetal" + (Str local0)) + ".ogg"))
                snd_i\Field56[(local0 + $07)] = loadsound_strict((("SFX\Step\NPCs\049\StepMetal" + (Str local0)) + ".ogg"))
                snd_i\Field56[(local0 + $0A)] = loadsound_strict((("SFX\Step\NPCs\096\Step" + (Str local0)) + ".ogg"))
            EndIf
        EndIf
        If (local0 < $05) Then
            breathsfx($00, local0) = loadsound_strict((("SFX\Character\D9341\Breath" + (Str local0)) + ".ogg"))
            breathsfx($01, local0) = loadsound_strict((("SFX\Character\D9341\Breath" + (Str local0)) + "Gas.ogg"))
        EndIf
        If (local0 < $06) Then
            snd_i\Field27[local0] = loadsound_strict((("SFX\SCP\372\Rustle" + (Str local0)) + ".ogg"))
        EndIf
        If (local0 < $08) Then
            stepsfx($00, $00, local0) = loadsound_strict((("SFX\Step\Step" + (Str local0)) + ".ogg"))
            stepsfx($00, $01, local0) = loadsound_strict((("SFX\Step\Run" + (Str local0)) + ".ogg"))
            stepsfx($01, $00, local0) = loadsound_strict((("SFX\Step\StepMetal" + (Str local0)) + ".ogg"))
            stepsfx($01, $01, local0) = loadsound_strict((("SFX\Step\RunMetal" + (Str local0)) + ".ogg"))
        EndIf
        If (local0 < $09) Then
            radiosfx($01, local0) = loadsound_strict((("SFX\Radio\SCPRadio" + (Str local0)) + ".ogg"))
        EndIf
        If (local0 < $0E) Then
            snd_i\Field47[local0] = loadsound_strict((("SFX\Horror\Horror" + (Str local0)) + ".ogg"))
        EndIf
        snd_i\Field51[local0] = loadsound_strict((("SFX\Character\D9341\Damage" + (Str local0)) + ".ogg"))
    Next
    snd_i\Field4 = loadsound_strict("SFX\Door\DoorOpen079.ogg")
    snd_i\Field3 = loadsound_strict("SFX\Door\DoorClose079.ogg")
    snd_i\Field8 = loadsound_strict("SFX\Interact\DoorLock.ogg")
    snd_i\Field9 = loadsound_strict("SFX\Door\DoorOpenFast.ogg")
    snd_i\Field10 = loadsound_strict("SFX\Room\LockroomSiren.ogg")
    snd_i\Field11 = loadsound_strict("SFX\Room\Camera.ogg")
    snd_i\Field12 = loadsound_strict("SFX\SCP\173\StoneDrag.ogg")
    snd_i\Field14 = loadsound_strict("SFX\Character\BulletMiss.ogg")
    snd_i\Field15 = loadsound_strict("SFX\Character\BulletHit.ogg")
    snd_i\Field16 = loadsound_strict("SFX\Room\Tesla\Idle.ogg")
    snd_i\Field17 = loadsound_strict("SFX\Room\Tesla\WindUp.ogg")
    snd_i\Field18 = loadsound_strict("SFX\Room\Tesla\PowerUp.ogg")
    snd_i\Field19 = loadsound_strict("SFX\Room\Tesla\Shock.ogg")
    snd_i\Field20 = loadsound_strict("SFX\Room\106Chamber\MagnetUp.ogg")
    snd_i\Field21 = loadsound_strict("SFX\Room\106Chamber\MagnetDown.ogg")
    snd_i\Field25 = loadsound_strict("SFX\Room\TunnelBurst.ogg")
    snd_i\Field29 = loadsound_strict("SFX\SCP\914\PlayerDeath.ogg")
    snd_i\Field28 = loadsound_strict("SFX\SCP\914\PlayerUse.ogg")
    snd_i\Field59 = loadsound_strict("SFX\SCP\914\Refining.ogg")
    snd_i\Field32 = loadsound_strict("SFX\Interact\LeverFlip.ogg")
    snd_i\Field34 = loadsound_strict("SFX\Room\LightSwitch.ogg")
    snd_i\Field35 = loadsound_strict("SFX\Radio\Squelch.ogg")
    snd_i\Field36 = loadsound_strict("SFX\Radio\Static.ogg")
    snd_i\Field37 = loadsound_strict("SFX\Radio\Static895.ogg")
    snd_i\Field38 = loadsound_strict("SFX\Radio\Buzz.ogg")
    snd_i\Field42 = loadsound_strict("SFX\General\Elevator\Beep.ogg")
    snd_i\Field43 = loadsound_strict("SFX\General\Elevator\Moving.ogg")
    ambientsfxamount[$00] = $08
    ambientsfxamount[$01] = $0B
    ambientsfxamount[$02] = $0C
    ambientsfxamount[$03] = $0F
    ambientsfxamount[$04] = $05
    ambientsfxamount[$05] = $0A
    snd_i\Field45[$03] = loadsound_strict("SFX\SCP\106\Laugh.ogg")
    snd_i\Field45[$04] = loadsound_strict("SFX\SCP\106\Breathing.ogg")
    snd_i\Field45[$05] = loadsound_strict("SFX\Room\PocketDimension\Enter.ogg")
    snd_i\Field52 = loadsound_strict("SFX\Character\D9341\HeartBeat.ogg")
    snd_i\Field60 = loadsound_strict("SFX\Character\Apache\Propeller.ogg")
    snd_i\Field57[$00] = loadsound_strict("SFX\Character\Vehicle\Idle.ogg")
    snd_i\Field57[$01] = loadsound_strict("SFX\Character\Vehicle\Move.ogg")
    snd_i\Field48 = loadsound_strict("SFX\Character\Miss.ogg")
    snd_i\Field55 = loadsound_strict("SFX\Character\D9341\BreathGasRelaxed.ogg")
    snd_i\Field23 = loadsound_strict("SFX\Character\D9341\Crouch.ogg")
    snd_i\Field39 = loadsound_strict("SFX\Interact\SCRAMBLE.ogg")
    snd_i\Field40[$00] = loadsound_strict("SFX\Interact\NVGOn.ogg")
    snd_i\Field40[$01] = loadsound_strict("SFX\Interact\NVGOff.ogg")
    snd_i\Field61 = loadsound_strict("SFX\Room\Blinds.ogg")
    snd_i\Field62 = loadsound_strict("SFX\Room\SparkShort.ogg")
    Return $00
End Function
