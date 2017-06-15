package fr.alex.kata.marsrover.adapter;

import fr.alex.kata.marsrover.command.CommandEnum;

public interface CommandAdapter<T> {

   CommandEnum adapt(T command);

}
